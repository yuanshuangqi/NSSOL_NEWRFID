package com.nssol.service.impl;

import com.nssol.controller.response.MessageResponse;
import com.nssol.dao.master.MasterPlanningHistoryInfo;
import com.nssol.dao.master.MasterPlanningInfo;
import com.nssol.dao.master.TBasicInfoDao;
import com.nssol.model.PlanningData;
import com.nssol.model.TBasicInfo;
import com.nssol.model.T_Planning_Detail;
import com.nssol.model.T_Planning_Info;
import com.nssol.service.BatchService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {
    @Autowired
    private TBasicInfoDao tBasicInfoDao;
    
    @Autowired
    private MasterPlanningInfo masterPlanningInfo;
    
    @Autowired
    private MasterPlanningHistoryInfo masterPlanningHistoryInfo;
    
    @Override
    public String getBasicInfo(String batchName){
        TBasicInfo tBasicInfo = new TBasicInfo();
        tBasicInfo.setType(batchName);
        TBasicInfo basicInfo = tBasicInfoDao.getBasicInfo(tBasicInfo);
        if(basicInfo==null){
            return null;
        }
        return basicInfo.getValue();
    }

    @Override
    public void setBasicInfo(String batchName,String batchCron){
        TBasicInfo tBasicInfo = new TBasicInfo();
        tBasicInfo.setType(batchName);
        tBasicInfo.setValue(batchCron);
        tBasicInfoDao.setBasicInfo(tBasicInfo);
    }

	@Override
	public MessageResponse insertPlanningData(PlanningData planningData) {
		MessageResponse messageResponse = new MessageResponse();
		BigDecimal qtyPerSetCount = new BigDecimal(0);
		if(planningData.getiD() == null || planningData.getiD() == "") {
			messageResponse.setCode("EL001");
			//messageResponse.setMessage("任务ID为空");
			messageResponse.setMessage("ID is null");
			return messageResponse;
		} else if(planningData.getOrderNo() == null || planningData.getOrderNo() == "") {
			messageResponse.setCode("EL002");
			//messageResponse.setMessage("PO No为空");
			messageResponse.setMessage("OrderNo is null");
			return messageResponse;
		} else if(planningData.getdONo() == null || planningData.getdONo() == "") {
			messageResponse.setCode("EL003");
			//messageResponse.setMessage("DO No为空");
			messageResponse.setMessage("DoNo is null");
			return messageResponse;
		} else if(planningData.getSetCode() == null || planningData.getSetCode() == "") {
			messageResponse.setCode("EL004");
			//messageResponse.setMessage("SET号为空");
			messageResponse.setMessage("SetCode is null");
			return messageResponse;
		} else if(planningData.getQty().equals(0)) {
			messageResponse.setCode("EL005");
			//messageResponse.setMessage("计划箱数为0");
			messageResponse.setMessage("Qty is zero");
			return messageResponse;
		} else if(planningData.getScanSort() == "0") {
			messageResponse.setCode("EL006");
			//messageResponse.setMessage("扫描顺序为0");
			messageResponse.setMessage("ScanSort is zero");
			return messageResponse;
		} else if(planningData.getProLine() == null || planningData.getProLine() == "") {
			messageResponse.setCode("EL008");
			//messageResponse.setMessage("产线为空");
			messageResponse.setMessage("Line is null");
			return messageResponse;
		} else {
			List<T_Planning_Detail> lsPlanningData = planningData.getLsPlanningDetail();
			for(T_Planning_Detail planDt : lsPlanningData) {
				//获取计划号
				planDt.setPlanningNum(planningData.getiD());
				//获取数量
				qtyPerSetCount = qtyPerSetCount.add(planDt.getQtyPerSet());
     		}
			planningData.setQtyPcs(qtyPerSetCount);
			
			// 类型新增
			if(planningData.getTransType() == 0) {
				// 判断history表是否存在
				T_Planning_Info planning = masterPlanningHistoryInfo.getPlanning(planningData);
				if(planning != null) {
					messageResponse.setCode("ESE001");
					messageResponse.setMessage("Record is exists");
					//messageResponse.setMessage("PlanningInfo记录已存在");
				} else {
					// 判断配比详细history表是否存在
					T_Planning_Detail planDt = new T_Planning_Detail();
					planDt.setPlanningNum(planningData.getLsPlanningDetail().get(0).getPlanningNum());
					List<T_Planning_Detail> lsPlanDt = masterPlanningHistoryInfo.getPlanningDetail(planDt);
					if(lsPlanDt != null  && !lsPlanDt.isEmpty()) {
						messageResponse.setCode("ESE002");
						messageResponse.setMessage("Record Detail is exists");
						//messageResponse.setMessage("PlanningDetail记录已存在");
					} else {
						// 将数据保存到对应业务表
						int countPlan = masterPlanningHistoryInfo.insertPlanningData(planningData);
						int countPlanDt = masterPlanningHistoryInfo.insertPlanningDetail(lsPlanningData);
						if(countPlan > 0 && countPlanDt > 0) {
							messageResponse.setCode("SIN001");
							messageResponse.setMessage("plannning is success");
							//messageResponse.setMessage("计划任务新增同步成功");
							// 判断配比是否存在
							T_Planning_Info tSetInfo = masterPlanningInfo.getPlanning(planningData);
							if(tSetInfo != null) {
								 countPlan = masterPlanningInfo.insertPlanningData(planningData);
								 countPlanDt = masterPlanningInfo.insertPlanningDetail(planningData);
								 // 业务表数据保存成功，则更新history表导入成功
								 if(countPlan > 0 && countPlanDt > 0) {
									 masterPlanningHistoryInfo.updatePlanningInfoImportFlg(planningData);
								 }
							}
							 
						} else {
							// 处理异常
							messageResponse.setCode("EIN001");
							messageResponse.setMessage("plannning is fail");
							//messageResponse.setMessage("计划任务新增同步失败 ");
						}
					}
				}
			} else if(planningData.getTransType() == 1) {
				// 类型修改
				// 判断History记录是否存在
				T_Planning_Info planning = masterPlanningHistoryInfo.getPlanning(planningData);
				if(planning == null) {
					messageResponse.setCode("ESE001");
					messageResponse.setMessage("Record is not exists");
					//messageResponse.setMessage("PlanningInfo记录不存在");
				} else {
					// 判断配比详细history表是否存在
					T_Planning_Detail planDt = new T_Planning_Detail();
					planDt.setPlanningNum(planningData.getLsPlanningDetail().get(0).getPlanningNum());
					List<T_Planning_Detail> lsPlanDt = masterPlanningHistoryInfo.getPlanningDetail(planDt);
					if(lsPlanDt == null || lsPlanDt.isEmpty()) {
						messageResponse.setCode("ESE002");
						messageResponse.setMessage("Record Detail is not exists");
						//messageResponse.setMessage("PlanningDetail记录不存在");
					} else {
						// 删除明细history表
						int delPlanDt = masterPlanningHistoryInfo.delPlanningDetail(planDt);
						if(delPlanDt > 0) {
							// 插入明细history表
							int countPlanDt =  masterPlanningHistoryInfo.insertPlanningDetail(lsPlanningData);
							// 更新history表
							int countPlan = masterPlanningHistoryInfo.upDatePlanningInfo(planningData);
							if(countPlanDt > 0 && countPlan > 0) {
								messageResponse.setCode("SUP001");
								messageResponse.setMessage("plannning is success");
								//messageResponse.setMessage("计划任务修改同步成功");
								
								// 业务表信息处理
								delPlanDt = masterPlanningInfo.delPlanningDetail(planDt);
								int delDt = masterPlanningInfo.delPlanningInfo(planningData);
								if(delPlanDt > 0 && delDt> 0) {
								 countPlan = masterPlanningInfo.insertPlanningData(planningData);
								 countPlanDt = masterPlanningInfo.insertPlanningDetail(planningData);
								}
								
							} else {
								messageResponse.setCode("EUP001");
								messageResponse.setMessage("plannning is fail");
								//messageResponse.setMessage("计划任务修改同步失败 ");
							}
						}
					}
				}
			} else if(planningData.getTransType() == 2) {
				// 类型删除
				T_Planning_Info planning = masterPlanningHistoryInfo.getPlanning(planningData);
				if(planning == null) {
					messageResponse.setCode("ESE001");
					messageResponse.setMessage("Record is not exists");
					//messageResponse.setMessage("PlanningInfo记录不存在");
				} else { 
					T_Planning_Detail planDt = new T_Planning_Detail();
					planDt.setPlanningNum(planningData.getLsPlanningDetail().get(0).getPlanningNum());
					List<T_Planning_Detail> lsPlanDt = masterPlanningHistoryInfo.getPlanningDetail(planDt);
					if(lsPlanDt == null || lsPlanDt.isEmpty()) {
						messageResponse.setCode("ESE002");
						messageResponse.setMessage("Record Detail is not exists");
						//messageResponse.setMessage("PlanningDetail记录不存在");
					} else {
						int countPlanDt =  masterPlanningHistoryInfo.delUpPlanningDetail(planDt);
						int countPlan = masterPlanningHistoryInfo.delUpPlanningInfo(planningData);
						if(countPlanDt > 0 && countPlan > 0) {
							messageResponse.setCode("SDE001");
							messageResponse.setMessage("plannning is success");
							//messageResponse.setMessage("计划任务删除同步成功");
							
							 countPlanDt =  masterPlanningInfo.delPlanningDetail(planDt);
							 countPlan = masterPlanningInfo.delPlanningInfo(planningData);
						} else {
							messageResponse.setCode("EDE001");
							messageResponse.setMessage("plannning is fail");
							//messageResponse.setMessage("计划任务删除同步失败 ");
						}
					}
				}
			}
		}
		return messageResponse;
	}

	@Override
	public void insertPlanningDataBatch() {
		List<T_Planning_Info> planList = masterPlanningHistoryInfo.getPlanningList();
		for(T_Planning_Info planDt : planList) {
			PlanningData planningData=new PlanningData();
			planningData.setiD(planDt.getPlanningNum());
			planningData.setOrderNo(planDt.getOrderNo());
			planningData.setdONo(planDt.getdONo());
			planningData.setSetCode(planDt.getSetCode());
			// 判断配比是否存在
			T_Planning_Info tSetInfo = masterPlanningInfo.getPlanning(planningData);
			if(tSetInfo != null) {
				int countPlan = masterPlanningInfo.insertPlanningData(planningData);
				int countPlanDt = masterPlanningInfo.insertPlanningDetail(planningData);
				// 业务表数据保存成功，则更新history表导入成功
				if(countPlan > 0 && countPlanDt > 0) {
					masterPlanningHistoryInfo.updatePlanningInfoImportFlg(planningData);
				}
			}
		}
	}
}

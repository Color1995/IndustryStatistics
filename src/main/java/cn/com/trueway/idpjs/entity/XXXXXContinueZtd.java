package cn.com.trueway.idpjs.entity;

import java.io.Serializable;

/**
 * 续建重特大
 * @author King1995
 * @date 2019年5月30日
 *
 */
public class XXXXXContinueZtd implements Serializable{

	private static final long serialVersionUID = -7376007551742745534L;
	
	public String id; //ID
	public String projectCode; //项目代码
	public String projectName; //项目名称
	public String constructionUnit; //建设单位
	public String porjectDescription; //建设规模及内容
	public int porjectInvest; //计划总投资
	public String area; //开发园区(商务局确认)
	public String ztdMark; //重特大项目标记（1新申报2为已认定3为亿元项目升级）
	public int usedMoney; //前期及其他费用
	public int landArea; //占地面积（亩）
	public int landPrice; //土地单价（万元/亩）
	public int landUsed; //已开工建筑面积（平方米）
	public int buildCost; //建筑成本(元/平方米）
	public int progress; //已建成进度
	public String remark; //备注
	public int projectType; //1工业2服务业4旅游
	public int projectState; //1现场核查2已认定项目抽查3竣工项目9重新审核
	public int grandTotal; //累计完成投资额
	public int grandTotalPrevious; //累计完成投资额(前期及其他费用)
	public int grandTotalLand; //累计完成投资额(土地费用)
	public int grandTotalBuild; //累计完成投资额(土建费用)
	public int grandTotalDevice; //累计完成投资额(设备投资额)
	public int checkResult; //设备投资额现场核查结果
	public int bnSbtze; //计算的本年设备投资额
	public int qnRdsbtze; //计算的本年设备投资额
	public int bnYrdsbtze; //计算的本年设备投资额
	public String reserved1; //预留字段1
	public String reserved2; //预留字段2
	public String year; //年份
	public String belongArea; //所属地区
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getConstructionUnit() {
		return constructionUnit;
	}
	public void setConstructionUnit(String construcyionUnit) {
		this.constructionUnit = construcyionUnit;
	}
	public String getPorjectDescription() {
		return porjectDescription;
	}
	public void setPorjectDescription(String porjectDescription) {
		this.porjectDescription = porjectDescription;
	}
	public int getPorjectInvest() {
		return porjectInvest;
	}
	public void setPorjectInvest(int porjectInvest) {
		this.porjectInvest = porjectInvest;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getZtdMark() {
		return ztdMark;
	}
	public void setZtdMark(String ztdMark) {
		this.ztdMark = ztdMark;
	}
	public int getUsedMoney() {
		return usedMoney;
	}
	public void setUsedMoney(int usedMoney) {
		this.usedMoney = usedMoney;
	}
	public int getLandArea() {
		return landArea;
	}
	public void setLandArea(int landArea) {
		this.landArea = landArea;
	}
	public int getLandPrice() {
		return landPrice;
	}
	public void setLandPrice(int landPrice) {
		this.landPrice = landPrice;
	}
	public int getLandUsed() {
		return landUsed;
	}
	public void setLandUsed(int landUsed) {
		this.landUsed = landUsed;
	}
	public int getBuildCost() {
		return buildCost;
	}
	public void setBuildCost(int buildCost) {
		this.buildCost = buildCost;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getProjectType() {
		return projectType;
	}
	public void setProjectType(int projectType) {
		this.projectType = projectType;
	}
	public int getProjectState() {
		return projectState;
	}
	public void setProjectState(int projectState) {
		this.projectState = projectState;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getGrandTotalPrevious() {
		return grandTotalPrevious;
	}
	public void setGrandTotalPrevious(int grandTotalPrevious) {
		this.grandTotalPrevious = grandTotalPrevious;
	}
	public int getGrandTotalLand() {
		return grandTotalLand;
	}
	public void setGrandTotalLand(int grandTotalLand) {
		this.grandTotalLand = grandTotalLand;
	}
	public int getGrandTotalBuild() {
		return grandTotalBuild;
	}
	public void setGrandTotalBuild(int grandTotalBuild) {
		this.grandTotalBuild = grandTotalBuild;
	}
	public int getGrandTotalDevice() {
		return grandTotalDevice;
	}
	public void setGrandTotalDevice(int grandTotalDevice) {
		this.grandTotalDevice = grandTotalDevice;
	}
	public int getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(int checkResult) {
		this.checkResult = checkResult;
	}
	public int getbnSbtze() {
		return bnSbtze;
	}
	public void setbnSbtze(int bN_SBTZE) {
		bnSbtze = bN_SBTZE;
	}
	public int getqnRdsbtze() {
		return qnRdsbtze;
	}
	public void setqnRdsbtze(int qN_RDSBTZE) {
		qnRdsbtze = qN_RDSBTZE;
	}
	public int getbnYrdsbtze() {
		return bnYrdsbtze;
	}
	public void setbnYrdsbtze(int bN_YRDSBTZE) {
		bnYrdsbtze = bN_YRDSBTZE;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public String getReserved2() {
		return reserved2;
	}
	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getBelongArea() {
		return belongArea;
	}
	public void setBelongArea(String belongArea) {
		this.belongArea = belongArea;
	}
	@Override
	public String toString() {
		return "Xjztd [id=" + id + ", projectCode=" + projectCode + ", projectName=" + projectName
				+ ", construcyionUnit=" + constructionUnit + ", porjectDescription=" + porjectDescription
				+ ", porjectInvest=" + porjectInvest + ", area=" + area + ", ztdMark=" + ztdMark + ", usedMoney="
				+ usedMoney + ", landArea=" + landArea + ", landPrice=" + landPrice + ", landUsed=" + landUsed
				+ ", buildCost=" + buildCost + ", progress=" + progress + ", remark=" + remark + ", projectType="
				+ projectType + ", projectState=" + projectState + ", grandTotal=" + grandTotal
				+ ", grandTotalPrevious=" + grandTotalPrevious + ", grandTotalLand=" + grandTotalLand
				+ ", grandTotalBuild=" + grandTotalBuild + ", grandTotalDevice=" + grandTotalDevice + ", checkResult="
				+ checkResult + ", bnSbtze=" + bnSbtze + ", qnRdsbtze=" + qnRdsbtze + ", bnYrdsbtze=" + bnYrdsbtze
				+ ", reserved1=" + reserved1 + ", reserved2=" + reserved2 + ", year=" + year + ", belongArea="
				+ belongArea + "]";
	}
	
}

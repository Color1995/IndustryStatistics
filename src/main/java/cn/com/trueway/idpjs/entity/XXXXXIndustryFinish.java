package cn.com.trueway.idpjs.entity;

import java.io.Serializable;

/**
 * 工业竣工项目
 * @author King1995
 * @date 2019年5月30日
 *
 */

public class XXXXXIndustryFinish implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public String id; //ID
	public String projectCode; //项目代码
	public String projectName; //项目名称
	public String construcyionUnit; //建设单位
	public String porjectDescription; //建设规模及内容
	public int porjectInvest; //计划总投资
	public int grandTotal; //累计完成投资额
	public int grandTotalDevice; //其中：完成设备投资额
	public int sales; //销售收入
	public String finishDate; //申请竣工日期
	public String area; //项目所在乡镇（园区）
	public String taxRegCode; //税务登记代码
	public String zhdc; //“转化达产”项目
	public int checkZhdc; //现场核查情况(转化认定计0.5)
	public String reserved1; //预留字段1
	public int checkResult; //设备投资额现场核查结果
	public int devicePrice; //计算的设备投资额
	public String RESERVED2; //预留字段2
	public String YEAR; //年份
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
	public String getConstrucyionUnit() {
		return construcyionUnit;
	}
	public void setConstrucyionUnit(String construcyionUnit) {
		this.construcyionUnit = construcyionUnit;
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
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getGrandTotalDevice() {
		return grandTotalDevice;
	}
	public void setGrandTotalDevice(int grandTotalDevice) {
		this.grandTotalDevice = grandTotalDevice;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTaxRegCode() {
		return taxRegCode;
	}
	public void setTaxRegCode(String taxRegCode) {
		this.taxRegCode = taxRegCode;
	}
	public String getZhdc() {
		return zhdc;
	}
	public void setZhdc(String zhdc) {
		this.zhdc = zhdc;
	}
	public int getCheckZhdc() {
		return checkZhdc;
	}
	public void setCheckZhdc(int checkZhdc) {
		this.checkZhdc = checkZhdc;
	}
	public String getReserved1() {
		return reserved1;
	}
	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}
	public int getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(int checkResult) {
		this.checkResult = checkResult;
	}
	public int getDevicePrice() {
		return devicePrice;
	}
	public void setDevicePrice(int devicePrice) {
		this.devicePrice = devicePrice;
	}
	public String getRESERVED2() {
		return RESERVED2;
	}
	public void setRESERVED2(String rESERVED2) {
		RESERVED2 = rESERVED2;
	}
	public String getYEAR() {
		return YEAR;
	}
	public void setYEAR(String yEAR) {
		YEAR = yEAR;
	}
	public String getBelongArea() {
		return belongArea;
	}
	public void setBelongArea(String belongArea) {
		this.belongArea = belongArea;
	}
	@Override
	public String toString() {
		return "Gyjgxm [id=" + id + ", projectCode=" + projectCode + ", projectName=" + projectName
				+ ", construcyionUnit=" + construcyionUnit + ", porjectDescription=" + porjectDescription
				+ ", porjectInvest=" + porjectInvest + ", grandTotal=" + grandTotal + ", grandTotalDevice="
				+ grandTotalDevice + ", sales=" + sales + ", finishDate=" + finishDate + ", area=" + area
				+ ", taxRegCode=" + taxRegCode + ", zhdc=" + zhdc + ", checkZhdc=" + checkZhdc + ", reserved1="
				+ reserved1 + ", checkResult=" + checkResult + ", devicePrice=" + devicePrice + ", RESERVED2="
				+ RESERVED2 + ", YEAR=" + YEAR + ", belongArea=" + belongArea + "]";
	}
	
}

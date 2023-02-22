package one.zpq.springbootdemo.snsmgmt;

public class Device {
    private String bizSequenceId;// 业务流水号
    private String merNo;// 商户编号
    private String merNameJc;// 商户简称
    private String deviceBrand;// 设备品牌
    private String deviceModel;// 设备型号
    private String deviceLocation;// 设备位置（经纬度）
    private String deviceAddress;// 设备所在位置
    private String deviceMac;// 设备mac地址
    private String deviceOs;// 设备操作系统
    private String deviceIpAddr;// 设备IP地址
    private String deviceMroName;// 设备维护人姓名
    private String deviceState;// 设备状态：未激活、已激活、锁定
    private String authorizeBizId;// 授权人信息表业务流水号

    public String getBizSequenceId() {
        return bizSequenceId;
    }

    public void setBizSequenceId(String bizSequenceId) {
        this.bizSequenceId = bizSequenceId;
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getMerNameJc() {
        return merNameJc;
    }

    public void setMerNameJc(String merNameJc) {
        this.merNameJc = merNameJc;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public String getDeviceIpAddr() {
        return deviceIpAddr;
    }

    public void setDeviceIpAddr(String deviceIpAddr) {
        this.deviceIpAddr = deviceIpAddr;
    }

    public String getDeviceMroName() {
        return deviceMroName;
    }

    public void setDeviceMroName(String deviceMroName) {
        this.deviceMroName = deviceMroName;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public String getAuthorizeBizId() {
        return authorizeBizId;
    }

    public void setAuthorizeBizId(String authorizeBizId) {
        this.authorizeBizId = authorizeBizId;
    }

    @Override
    public String toString() {
        return "Device [bizSequenceId=" + bizSequenceId + ", merNo=" + merNo + ", merNameJc=" + merNameJc
                + ", deviceBrand=" + deviceBrand + ", deviceModel=" + deviceModel + ", deviceLocation=" + deviceLocation
                + ", deviceAddress=" + deviceAddress + ", deviceMac=" + deviceMac + ", deviceOs=" + deviceOs
                + ", deviceIpAddr=" + deviceIpAddr + ", deviceMroName=" + deviceMroName + ", deviceState=" + deviceState
                + ", authorizeBizId=" + authorizeBizId + "]";
    }

}

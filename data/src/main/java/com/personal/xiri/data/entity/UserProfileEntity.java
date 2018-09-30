package com.personal.xiri.data.entity;

import com.personal.xiri.data.entity.converter.StringConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Gaojianyang on 18/9/13.
 * github https://github.com/gaojianyang
 */
@Entity(nameInDb = "user_info",indexes = {@Index(value = "identifier")})
public class UserProfileEntity {
    @Id(autoincrement = true)
    private long id;
    private String identifier = "";
    private String peer="";
    private String nickName = "";
    private String allowType = "";
    private String remark = "";
    private String faceUrl = "";
    private String selfSignature = "";
    private long gender = 0L;
    private long birthday = 0L;
    private long language = 0L;
    private String location = "";
    @Convert(columnType = String.class, converter = StringConverter.class)
    private List<String> groupNames;
    private long skinId;
    private String lastMsg;
    private long lastTimeStamp;
    private long seq;
    private String reserve;


    @Generated(hash = 2111376296)
    public UserProfileEntity(long id, String identifier, String peer,
            String nickName, String allowType, String remark, String faceUrl,
            String selfSignature, long gender, long birthday, long language,
            String location, List<String> groupNames, long skinId, String lastMsg,
            long lastTimeStamp, long seq, String reserve) {
        this.id = id;
        this.identifier = identifier;
        this.peer = peer;
        this.nickName = nickName;
        this.allowType = allowType;
        this.remark = remark;
        this.faceUrl = faceUrl;
        this.selfSignature = selfSignature;
        this.gender = gender;
        this.birthday = birthday;
        this.language = language;
        this.location = location;
        this.groupNames = groupNames;
        this.skinId = skinId;
        this.lastMsg = lastMsg;
        this.lastTimeStamp = lastTimeStamp;
        this.seq = seq;
        this.reserve = reserve;
    }

    @Generated(hash = 1557014447)
    public UserProfileEntity() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAllowType() {
        return allowType;
    }

    public void setAllowType(String allowType) {
        this.allowType = allowType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getSelfSignature() {
        return selfSignature;
    }

    public void setSelfSignature(String selfSignature) {
        this.selfSignature = selfSignature;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public long getLanguage() {
        return language;
    }

    public void setLanguage(long language) {
        this.language = language;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List<String> groupNames) {
        this.groupNames = groupNames;
    }

    public long getSkinId() {
        return skinId;
    }

    public void setSkinId(long skinId) {
        this.skinId = skinId;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public long getLastTimeStamp() {
        return lastTimeStamp;
    }

    public void setLastTimeStamp(long lastTimeStamp) {
        this.lastTimeStamp = lastTimeStamp;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }
}

package com.personal.xiri.data.entity;

/**
 * Created by Gaojianyang on 18/9/6.
 * github https://github.com/gaojianyang
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "skin_info",indexes = {@Index(value = "remoteId")})
public class SkinEntity {
    @Id(autoincrement = true)
    private long id;
    private long remoteId;
    private int themeId;
    private int type;
    private int syncStatus;
    private String authorName;
    private String authorIdentifier;
    private String skinName;
    private String skinSum;
    private String baseImgPath;
    private String remotePath;
    private String identifier;
    private String createDate;
    private String updateDate;
    private String thumbMainImgName;
    private String thumbDrawerImgName;
    private String skinCoverImgName;
    private String skinDpi;
    private String skinOs;
    private String skinData;

    @Generated(hash = 123376439)
    public SkinEntity(long id, long remoteId, int themeId, int type, int syncStatus,
            String authorName, String authorIdentifier, String skinName,
            String skinSum, String baseImgPath, String remotePath,
            String identifier, String createDate, String updateDate,
            String thumbMainImgName, String thumbDrawerImgName,
            String skinCoverImgName, String skinDpi, String skinOs,
            String skinData) {
        this.id = id;
        this.remoteId = remoteId;
        this.themeId = themeId;
        this.type = type;
        this.syncStatus = syncStatus;
        this.authorName = authorName;
        this.authorIdentifier = authorIdentifier;
        this.skinName = skinName;
        this.skinSum = skinSum;
        this.baseImgPath = baseImgPath;
        this.remotePath = remotePath;
        this.identifier = identifier;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.thumbMainImgName = thumbMainImgName;
        this.thumbDrawerImgName = thumbDrawerImgName;
        this.skinCoverImgName = skinCoverImgName;
        this.skinDpi = skinDpi;
        this.skinOs = skinOs;
        this.skinData = skinData;
    }

    @Generated(hash = 237489517)
    public SkinEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(long remoteId) {
        this.remoteId = remoteId;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorIdentifier() {
        return authorIdentifier;
    }

    public void setAuthorIdentifier(String authorIdentifier) {
        this.authorIdentifier = authorIdentifier;
    }

    public String getSkinName() {
        return skinName;
    }

    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    public String getSkinSum() {
        return skinSum;
    }

    public void setSkinSum(String skinSum) {
        this.skinSum = skinSum;
    }

    public String getBaseImgPath() {
        return baseImgPath;
    }

    public void setBaseImgPath(String baseImgPath) {
        this.baseImgPath = baseImgPath;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getThumbMainImgName() {
        return thumbMainImgName;
    }

    public void setThumbMainImgName(String thumbMainImgName) {
        this.thumbMainImgName = thumbMainImgName;
    }

    public String getThumbDrawerImgName() {
        return thumbDrawerImgName;
    }

    public void setThumbDrawerImgName(String thumbDrawerImgName) {
        this.thumbDrawerImgName = thumbDrawerImgName;
    }

    public String getSkinCoverImgName() {
        return skinCoverImgName;
    }

    public void setSkinCoverImgName(String skinCoverImgName) {
        this.skinCoverImgName = skinCoverImgName;
    }

    public String getSkinDpi() {
        return skinDpi;
    }

    public void setSkinDpi(String skinDpi) {
        this.skinDpi = skinDpi;
    }

    public String getSkinOs() {
        return skinOs;
    }

    public void setSkinOs(String skinOs) {
        this.skinOs = skinOs;
    }

    public String getSkinData() {
        return skinData;
    }

    public void setSkinData(String skinData) {
        this.skinData = skinData;
    }
}

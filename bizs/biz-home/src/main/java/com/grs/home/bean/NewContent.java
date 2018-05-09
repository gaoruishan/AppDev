package com.grs.home.bean;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * <p class="note">File Note</p>
 */


public class NewContent {

	private int pageNum;
	private int pageSize;
	private int totalCount;
	private int pageCount;
	private List<ResultsBean> results;

	public static NewContent objectFromData(String str) {

		return new com.google.gson.Gson().fromJson(str, NewContent.class);
	}

	public static NewContent objectFromData(String str, String key) {

		try {
			JSONObject jsonObject = new JSONObject(str);

			return new com.google.gson.Gson().fromJson(jsonObject.getString(str), NewContent.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<NewContent> arrayRetResultBeanFromData(String str) {

		Type listType = new com.google.gson.reflect.TypeToken<ArrayList<NewContent>>() {
		}.getType();

		return new com.google.gson.Gson().fromJson(str, listType);
	}

	public static List<NewContent> arrayRetResultBeanFromData(String str, String key) {

		try {
			JSONObject jsonObject = new JSONObject(str);
			Type listType = new com.google.gson.reflect.TypeToken<ArrayList<NewContent>>() {
			}.getType();

			return new com.google.gson.Gson().fromJson(jsonObject.getString(str), listType);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new ArrayList();


	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}

	public static class ResultsBean {
		/**
		 * id : 47411
		 * categoryId : null
		 * emotion : null
		 * title : 慢不了的生活，少不了的意面！
		 * keywords : null
		 * status : 0
		 * showType : 0
		 * businessType : 0
		 * statusDesp :
		 * clickCount : 8037
		 * resourceId : []
		 * resourceUrl : null
		 * createTime : 1517375266000
		 * updateTime : 1518334406000
		 * createUser : 热门内容
		 * updateUser : 201705021357033027
		 * createFrom : null
		 * supportNumber : 1
		 * notSupportNumber : 0
		 * lastReplyTime : 1518418370000
		 * lastReplyUser : null
		 * replys : null
		 * favoritenumber : 1
		 * replynumber : 0
		 * elitetime : null
		 * tags : []
		 * userId : 2016051920505100181
		 * content :
		 * fridgeModel :
		 * mobileModel :
		 * mobileSystemVersion :
		 * appVersion :
		 * supportStatus : false
		 * collectionStatus : false
		 * postScore : 200
		 * postNewScore : null
		 * postColumnId : 255
		 * postColumnName : 生活
		 * postBrowse : 37
		 * postShare : 0
		 * postExamine : 0
		 * postSource : 0
		 * postSort : 0
		 * postType : 2
		 * postVoidUrl : http://fs.onehaier.com/videos/2018/01/31/10486006_224759-sd_2018-01-310107.mp4
		 * postCoverUrl : http://fs.onehaier.com/leaveMsg/2018/01/31/20180131130632_2018-01-310107.png
		 * userName : 热门内容
		 * timeType : 5小时前
		 * faceImageId : https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4002125173,2162960728&fm=27&gp=0.jpg
		 * showName : null
		 * voidTime :
		 * isSupport : 0
		 * challengType : 254
		 * feedType : 0
		 * feedTime : 1518401320000
		 * wxSubject : 0
		 * isChallenge : 0
		 * subjectRanking : null
		 * stairName : 生活
		 * isUserSubject : 0
		 * void_type : 0
		 * replyDto : []
		 * resourceIdStr : null
		 * resourceUrlStr : null
		 * tagsStr : null
		 */

		private int id;
		private Object categoryId;
		private Object emotion;
		private String title;
		private Object keywords;
		private int status;
		private int showType;
		private int businessType;
		private String statusDesp;
		private int clickCount;
		private List<String> resourceUrl;
		private long createTime;
		private long updateTime;
		private String createUser;
		private String updateUser;
		private Object createFrom;
		private int supportNumber;
		private int notSupportNumber;
		private long lastReplyTime;
		private Object lastReplyUser;
		private Object replys;
		private int favoritenumber;
		private int replynumber;
		private Object elitetime;
		private long userId;
		private String content;
		private String fridgeModel;
		private String mobileModel;
		private String mobileSystemVersion;
		private String appVersion;
		private boolean supportStatus;
		private boolean collectionStatus;
		private int postScore;
		private Object postNewScore;
		private int postColumnId;
		private String postColumnName;
		private int postBrowse;
		private int postShare;
		private int postExamine;
		private int postSource;
		private int postSort;
		private int postType;
		private String postVoidUrl;
		private String postCoverUrl;
		private String userName;
		private String timeType;
		private String faceImageId;
		private Object showName;
		private String voidTime;
		private int isSupport;
		private int challengType;
		private int feedType;
		private long feedTime;
		private int wxSubject;
		private int isChallenge;
		private Object subjectRanking;
		private String stairName;
		private int isUserSubject;
		private int void_type;
		private Object resourceIdStr;
		private Object resourceUrlStr;
		private Object tagsStr;
		private List<?> resourceId;
		private List<?> tags;
		private List<?> replyDto;

		public static ResultsBean objectFromData(String str) {

			return new com.google.gson.Gson().fromJson(str, ResultsBean.class);
		}

		public static ResultsBean objectFromData(String str, String key) {

			try {
				JSONObject jsonObject = new JSONObject(str);

				return new com.google.gson.Gson().fromJson(jsonObject.getString(str), ResultsBean.class);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		public static List<ResultsBean> arrayResultsBeanFromData(String str) {

			Type listType = new com.google.gson.reflect.TypeToken<ArrayList<ResultsBean>>() {
			}.getType();

			return new com.google.gson.Gson().fromJson(str, listType);
		}

		public static List<ResultsBean> arrayResultsBeanFromData(String str, String key) {

			try {
				JSONObject jsonObject = new JSONObject(str);
				Type listType = new com.google.gson.reflect.TypeToken<ArrayList<ResultsBean>>() {
				}.getType();

				return new com.google.gson.Gson().fromJson(jsonObject.getString(str), listType);

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return new ArrayList();


		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Object getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Object categoryId) {
			this.categoryId = categoryId;
		}

		public Object getEmotion() {
			return emotion;
		}

		public void setEmotion(Object emotion) {
			this.emotion = emotion;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Object getKeywords() {
			return keywords;
		}

		public void setKeywords(Object keywords) {
			this.keywords = keywords;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public int getShowType() {
			return showType;
		}

		public void setShowType(int showType) {
			this.showType = showType;
		}

		public int getBusinessType() {
			return businessType;
		}

		public void setBusinessType(int businessType) {
			this.businessType = businessType;
		}

		public String getStatusDesp() {
			return statusDesp;
		}

		public void setStatusDesp(String statusDesp) {
			this.statusDesp = statusDesp;
		}

		public int getClickCount() {
			return clickCount;
		}

		public void setClickCount(int clickCount) {
			this.clickCount = clickCount;
		}

		public List<String> getResourceUrl() {
			return resourceUrl;
		}

		public void setResourceUrl(List<String> resourceUrl) {
			this.resourceUrl = resourceUrl;
		}

		public long getCreateTime() {
			return createTime;
		}

		public void setCreateTime(long createTime) {
			this.createTime = createTime;
		}

		public long getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(long updateTime) {
			this.updateTime = updateTime;
		}

		public String getCreateUser() {
			return createUser;
		}

		public void setCreateUser(String createUser) {
			this.createUser = createUser;
		}

		public String getUpdateUser() {
			return updateUser;
		}

		public void setUpdateUser(String updateUser) {
			this.updateUser = updateUser;
		}

		public Object getCreateFrom() {
			return createFrom;
		}

		public void setCreateFrom(Object createFrom) {
			this.createFrom = createFrom;
		}

		public int getSupportNumber() {
			return supportNumber;
		}

		public void setSupportNumber(int supportNumber) {
			this.supportNumber = supportNumber;
		}

		public int getNotSupportNumber() {
			return notSupportNumber;
		}

		public void setNotSupportNumber(int notSupportNumber) {
			this.notSupportNumber = notSupportNumber;
		}

		public long getLastReplyTime() {
			return lastReplyTime;
		}

		public void setLastReplyTime(long lastReplyTime) {
			this.lastReplyTime = lastReplyTime;
		}

		public Object getLastReplyUser() {
			return lastReplyUser;
		}

		public void setLastReplyUser(Object lastReplyUser) {
			this.lastReplyUser = lastReplyUser;
		}

		public Object getReplys() {
			return replys;
		}

		public void setReplys(Object replys) {
			this.replys = replys;
		}

		public int getFavoritenumber() {
			return favoritenumber;
		}

		public void setFavoritenumber(int favoritenumber) {
			this.favoritenumber = favoritenumber;
		}

		public int getReplynumber() {
			return replynumber;
		}

		public void setReplynumber(int replynumber) {
			this.replynumber = replynumber;
		}

		public Object getElitetime() {
			return elitetime;
		}

		public void setElitetime(Object elitetime) {
			this.elitetime = elitetime;
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getFridgeModel() {
			return fridgeModel;
		}

		public void setFridgeModel(String fridgeModel) {
			this.fridgeModel = fridgeModel;
		}

		public String getMobileModel() {
			return mobileModel;
		}

		public void setMobileModel(String mobileModel) {
			this.mobileModel = mobileModel;
		}

		public String getMobileSystemVersion() {
			return mobileSystemVersion;
		}

		public void setMobileSystemVersion(String mobileSystemVersion) {
			this.mobileSystemVersion = mobileSystemVersion;
		}

		public String getAppVersion() {
			return appVersion;
		}

		public void setAppVersion(String appVersion) {
			this.appVersion = appVersion;
		}

		public boolean isSupportStatus() {
			return supportStatus;
		}

		public void setSupportStatus(boolean supportStatus) {
			this.supportStatus = supportStatus;
		}

		public boolean isCollectionStatus() {
			return collectionStatus;
		}

		public void setCollectionStatus(boolean collectionStatus) {
			this.collectionStatus = collectionStatus;
		}

		public int getPostScore() {
			return postScore;
		}

		public void setPostScore(int postScore) {
			this.postScore = postScore;
		}

		public Object getPostNewScore() {
			return postNewScore;
		}

		public void setPostNewScore(Object postNewScore) {
			this.postNewScore = postNewScore;
		}

		public int getPostColumnId() {
			return postColumnId;
		}

		public void setPostColumnId(int postColumnId) {
			this.postColumnId = postColumnId;
		}

		public String getPostColumnName() {
			return postColumnName;
		}

		public void setPostColumnName(String postColumnName) {
			this.postColumnName = postColumnName;
		}

		public int getPostBrowse() {
			return postBrowse;
		}

		public void setPostBrowse(int postBrowse) {
			this.postBrowse = postBrowse;
		}

		public int getPostShare() {
			return postShare;
		}

		public void setPostShare(int postShare) {
			this.postShare = postShare;
		}

		public int getPostExamine() {
			return postExamine;
		}

		public void setPostExamine(int postExamine) {
			this.postExamine = postExamine;
		}

		public int getPostSource() {
			return postSource;
		}

		public void setPostSource(int postSource) {
			this.postSource = postSource;
		}

		public int getPostSort() {
			return postSort;
		}

		public void setPostSort(int postSort) {
			this.postSort = postSort;
		}

		public int getPostType() {
			return postType;
		}

		public void setPostType(int postType) {
			this.postType = postType;
		}

		public String getPostVoidUrl() {
			return postVoidUrl;
		}

		public void setPostVoidUrl(String postVoidUrl) {
			this.postVoidUrl = postVoidUrl;
		}

		public String getPostCoverUrl() {
			return postCoverUrl;
		}

		public void setPostCoverUrl(String postCoverUrl) {
			this.postCoverUrl = postCoverUrl;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getTimeType() {
			return timeType;
		}

		public void setTimeType(String timeType) {
			this.timeType = timeType;
		}

		public String getFaceImageId() {
			return faceImageId;
		}

		public void setFaceImageId(String faceImageId) {
			this.faceImageId = faceImageId;
		}

		public Object getShowName() {
			return showName;
		}

		public void setShowName(Object showName) {
			this.showName = showName;
		}

		public String getVoidTime() {
			return voidTime;
		}

		public void setVoidTime(String voidTime) {
			this.voidTime = voidTime;
		}

		public int getIsSupport() {
			return isSupport;
		}

		public void setIsSupport(int isSupport) {
			this.isSupport = isSupport;
		}

		public int getChallengType() {
			return challengType;
		}

		public void setChallengType(int challengType) {
			this.challengType = challengType;
		}

		public int getFeedType() {
			return feedType;
		}

		public void setFeedType(int feedType) {
			this.feedType = feedType;
		}

		public long getFeedTime() {
			return feedTime;
		}

		public void setFeedTime(long feedTime) {
			this.feedTime = feedTime;
		}

		public int getWxSubject() {
			return wxSubject;
		}

		public void setWxSubject(int wxSubject) {
			this.wxSubject = wxSubject;
		}

		public int getIsChallenge() {
			return isChallenge;
		}

		public void setIsChallenge(int isChallenge) {
			this.isChallenge = isChallenge;
		}

		public Object getSubjectRanking() {
			return subjectRanking;
		}

		public void setSubjectRanking(Object subjectRanking) {
			this.subjectRanking = subjectRanking;
		}

		public String getStairName() {
			return stairName;
		}

		public void setStairName(String stairName) {
			this.stairName = stairName;
		}

		public int getIsUserSubject() {
			return isUserSubject;
		}

		public void setIsUserSubject(int isUserSubject) {
			this.isUserSubject = isUserSubject;
		}

		public int getVoid_type() {
			return void_type;
		}

		public void setVoid_type(int void_type) {
			this.void_type = void_type;
		}

		public Object getResourceIdStr() {
			return resourceIdStr;
		}

		public void setResourceIdStr(Object resourceIdStr) {
			this.resourceIdStr = resourceIdStr;
		}

		public Object getResourceUrlStr() {
			return resourceUrlStr;
		}

		public void setResourceUrlStr(Object resourceUrlStr) {
			this.resourceUrlStr = resourceUrlStr;
		}

		public Object getTagsStr() {
			return tagsStr;
		}

		public void setTagsStr(Object tagsStr) {
			this.tagsStr = tagsStr;
		}

		public List<?> getResourceId() {
			return resourceId;
		}

		public void setResourceId(List<?> resourceId) {
			this.resourceId = resourceId;
		}

		public List<?> getTags() {
			return tags;
		}

		public void setTags(List<?> tags) {
			this.tags = tags;
		}

		public List<?> getReplyDto() {
			return replyDto;
		}

		public void setReplyDto(List<?> replyDto) {
			this.replyDto = replyDto;
		}
	}
}

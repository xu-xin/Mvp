package com.itheima.vmplayer.bean;

import java.util.List;

/**
 * Created by xx on 2017/2/16.
 */

public class MeiNvBean {


    private boolean isClusterfilter;
    private int isPornQuery;
    private String isQcResult;
    private boolean isTinyQcNull;
    private int itemsOnPage;
    private int maxEnd;
    private String query;
    private String refineQuery;
    private String refineQueryEncode;
    private boolean showFiltered;
    private int startIndex;
    private String tc;
    private String totalItems;
    private String ts;
    private String uuid;
    private List<String> hintWords;
    private List<ItemsBean> items;

    public boolean isIsClusterfilter() {
        return isClusterfilter;
    }

    public void setIsClusterfilter(boolean isClusterfilter) {
        this.isClusterfilter = isClusterfilter;
    }

    public int getIsPornQuery() {
        return isPornQuery;
    }

    public void setIsPornQuery(int isPornQuery) {
        this.isPornQuery = isPornQuery;
    }

    public String getIsQcResult() {
        return isQcResult;
    }

    public void setIsQcResult(String isQcResult) {
        this.isQcResult = isQcResult;
    }

    public boolean isIsTinyQcNull() {
        return isTinyQcNull;
    }

    public void setIsTinyQcNull(boolean isTinyQcNull) {
        this.isTinyQcNull = isTinyQcNull;
    }

    public int getItemsOnPage() {
        return itemsOnPage;
    }

    public void setItemsOnPage(int itemsOnPage) {
        this.itemsOnPage = itemsOnPage;
    }

    public int getMaxEnd() {
        return maxEnd;
    }

    public void setMaxEnd(int maxEnd) {
        this.maxEnd = maxEnd;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRefineQuery() {
        return refineQuery;
    }

    public void setRefineQuery(String refineQuery) {
        this.refineQuery = refineQuery;
    }

    public String getRefineQueryEncode() {
        return refineQueryEncode;
    }

    public void setRefineQueryEncode(String refineQueryEncode) {
        this.refineQueryEncode = refineQueryEncode;
    }

    public boolean isShowFiltered() {
        return showFiltered;
    }

    public void setShowFiltered(boolean showFiltered) {
        this.showFiltered = showFiltered;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<String> getHintWords() {
        return hintWords;
    }

    public void setHintWords(List<String> hintWords) {
        this.hintWords = hintWords;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {

        private boolean allSummary;
        private String base_url;
        private int cacheIndex;
        private String docid;
        private boolean easter;
        private boolean fastSummary;
        private String formattedSummary;
        private int groupsize;
        private String height;
        private String hittag;
        private String imgcolor;
        private String imgkey1;
        private String imgkey2;
        private String lastmodified;
        private String markedTitle;
        private String mf_id;
        private boolean normalSummary;
        private String oriTitle;
        private String page_url;
        private String pic_url;
        private String pic_url_noredirect;
        private boolean showSnapShot;
        private String size;
        private String smallThumbUrl;
        private String sohu_image;
        private String summarypc;
        private String summarytype;
        private String surr2;
        private String thumbUrl;
        private String thumb_height;
        private String thumb_width;
        private int time;
        private String title;
        private String title1;
        private int type;
        private String uri;
        private String width;

        public boolean isAllSummary() {
            return allSummary;
        }

        public void setAllSummary(boolean allSummary) {
            this.allSummary = allSummary;
        }

        public String getBase_url() {
            return base_url;
        }

        public void setBase_url(String base_url) {
            this.base_url = base_url;
        }

        public int getCacheIndex() {
            return cacheIndex;
        }

        public void setCacheIndex(int cacheIndex) {
            this.cacheIndex = cacheIndex;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public boolean isEaster() {
            return easter;
        }

        public void setEaster(boolean easter) {
            this.easter = easter;
        }

        public boolean isFastSummary() {
            return fastSummary;
        }

        public void setFastSummary(boolean fastSummary) {
            this.fastSummary = fastSummary;
        }

        public String getFormattedSummary() {
            return formattedSummary;
        }

        public void setFormattedSummary(String formattedSummary) {
            this.formattedSummary = formattedSummary;
        }

        public int getGroupsize() {
            return groupsize;
        }

        public void setGroupsize(int groupsize) {
            this.groupsize = groupsize;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getHittag() {
            return hittag;
        }

        public void setHittag(String hittag) {
            this.hittag = hittag;
        }

        public String getImgcolor() {
            return imgcolor;
        }

        public void setImgcolor(String imgcolor) {
            this.imgcolor = imgcolor;
        }

        public String getImgkey1() {
            return imgkey1;
        }

        public void setImgkey1(String imgkey1) {
            this.imgkey1 = imgkey1;
        }

        public String getImgkey2() {
            return imgkey2;
        }

        public void setImgkey2(String imgkey2) {
            this.imgkey2 = imgkey2;
        }

        public String getLastmodified() {
            return lastmodified;
        }

        public void setLastmodified(String lastmodified) {
            this.lastmodified = lastmodified;
        }

        public String getMarkedTitle() {
            return markedTitle;
        }

        public void setMarkedTitle(String markedTitle) {
            this.markedTitle = markedTitle;
        }

        public String getMf_id() {
            return mf_id;
        }

        public void setMf_id(String mf_id) {
            this.mf_id = mf_id;
        }

        public boolean isNormalSummary() {
            return normalSummary;
        }

        public void setNormalSummary(boolean normalSummary) {
            this.normalSummary = normalSummary;
        }

        public String getOriTitle() {
            return oriTitle;
        }

        public void setOriTitle(String oriTitle) {
            this.oriTitle = oriTitle;
        }

        public String getPage_url() {
            return page_url;
        }

        public void setPage_url(String page_url) {
            this.page_url = page_url;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getPic_url_noredirect() {
            return pic_url_noredirect;
        }

        public void setPic_url_noredirect(String pic_url_noredirect) {
            this.pic_url_noredirect = pic_url_noredirect;
        }

        public boolean isShowSnapShot() {
            return showSnapShot;
        }

        public void setShowSnapShot(boolean showSnapShot) {
            this.showSnapShot = showSnapShot;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getSmallThumbUrl() {
            return smallThumbUrl;
        }

        public void setSmallThumbUrl(String smallThumbUrl) {
            this.smallThumbUrl = smallThumbUrl;
        }

        public String getSohu_image() {
            return sohu_image;
        }

        public void setSohu_image(String sohu_image) {
            this.sohu_image = sohu_image;
        }

        public String getSummarypc() {
            return summarypc;
        }

        public void setSummarypc(String summarypc) {
            this.summarypc = summarypc;
        }

        public String getSummarytype() {
            return summarytype;
        }

        public void setSummarytype(String summarytype) {
            this.summarytype = summarytype;
        }

        public String getSurr2() {
            return surr2;
        }

        public void setSurr2(String surr2) {
            this.surr2 = surr2;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public String getThumb_height() {
            return thumb_height;
        }

        public void setThumb_height(String thumb_height) {
            this.thumb_height = thumb_height;
        }

        public String getThumb_width() {
            return thumb_width;
        }

        public void setThumb_width(String thumb_width) {
            this.thumb_width = thumb_width;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle1() {
            return title1;
        }

        public void setTitle1(String title1) {
            this.title1 = title1;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getWidth() {
            return width;
        }

        public void setWidth(String width) {
            this.width = width;
        }
    }
}

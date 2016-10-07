package Controller;

import org.json.simple.JSONObject;

public class EventReviews {
	private String id;
    private String picture ;
    private String reviewComments ;
    private String reviewPoints ;

    public EventReviews () {}

    public EventReviews (String id, String picture, String reviewComments, String reviewPoints) {
        setEventId(id) ;
        setPicture(picture) ;
        setReviewComments(reviewComments) ;
        setReviewPoints(reviewPoints) ;
    }

    public String getEventId() {
        return id;
    }

    public void setEventId(String id) {
        this.id = id;
    }

    public String getPictuture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }

    public String getReviewPoints() {
        return reviewPoints;
    }

    public void setReviewPoints(String reviewPoints) {
        this.reviewPoints = reviewPoints;
    }

    public String toString() {
        JSONObject o = new JSONObject() ;

        o.put("ReviewPoints", reviewPoints) ;
        o.put("ReviewComments", reviewComments)  ;
        o.put("EventPicture", picture);
        o.put("EventID", id) ;

        return o.toString() ;
    }
}

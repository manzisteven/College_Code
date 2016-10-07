package Controller;

import org.json.simple.JSONObject;

public class FreeFoodEvent {
	private int id;
    private String topic ;
    private String location ;
    private String timestamp ;

    public FreeFoodEvent () {}

    public FreeFoodEvent (int id, String topic, String location, String timestamp) {
        setId(id) ;
        setTopic(topic) ;
        setLocation(location) ;
        setTimestamp(timestamp) ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        JSONObject o = new JSONObject() ;

        o.put("Time", timestamp) ;
        o.put("Location", location)  ;
        o.put("Topic", topic);
        o.put("Id", id) ;

        return o.toString() ;
    }

}

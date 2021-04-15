package resources;

public enum APIResources {
    addUserAPI("/users"),
    getCommentsAPI("/comments?postId=1"),
    deletePostAPI("/posts/1");

    private String resource;
    APIResources(String resource){
        this.resource=resource;
    }
    public String getResource() {
        return resource;
    }
}

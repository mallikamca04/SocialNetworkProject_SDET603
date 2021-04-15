Feature: Validating social Network API's
  @AddUser
  Scenario: verify if user being added using AddPostAPI
    Given AddPost Payload
    When User calls "addUserAPI" with "post" httprequest
    Then the API call is success with status code 201
    And "statusLine" in response body is "HTTP/1.1 201 Created"

    @GetComments
    Scenario: Verify comments for a given postID
      Given postID Payload
      When User calls "getCommentsAPI" with "get" httprequest
      Then the API call is success with status code 200
      And number of comments returned is 5

      @DeletePosts
      Scenario: verify delete API for a given postID
        Given postID Payload
        When User calls "deletePostAPI" with "Delete" httprequest
        Then the API call is success with status code 200


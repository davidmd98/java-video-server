package isdcm.webapp1.services;

import isdcm.webapp1.model.Video;
import java.util.List;
import java.util.Arrays;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david
 */
public class VideoApiService {

    private Client client = ClientBuilder.newClient();
    private WebTarget targetAuthor;
    private WebTarget targetTitle;
    private WebTarget targetCreationDate;

    public VideoApiService(String authorEndpoint, String titleEndpoint, String dateEndpoint) {
        targetAuthor = client.target(authorEndpoint);
        targetTitle = client.target(titleEndpoint);
        targetCreationDate = client.target(dateEndpoint);
    }

    public List<Video> getVideosByAuthor(String authorSearch) {
        try {
            //api call
            String jsonBody = "{\"author\":" + authorSearch + "\"}";
            Response response = targetAuthor
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(jsonBody, MediaType.APPLICATION_JSON));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Response from the Server: ");
                System.out.println(response);
                Video[] listVideo = response.readEntity(Video[].class);
                return Arrays.asList(listVideo);
            } else {
                throw new RuntimeException("HTTP Error: " + response.getStatus());
            }

        } catch (Exception e) {
            return null;
        }
    }
    public List<Video> getVideosByCreationDate(String dateSearch) {
        /*
        try {
            //api call
            // TODO: json body con start y end
            String jsonBody = "{\"author\":" + authorSearch + "\"}";
            Response response = targetCreationDate
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(jsonBody, MediaType.APPLICATION_JSON));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Response from the Server: ");
                System.out.println(response);
                Video[] listVideo = response.readEntity(Video[].class);
                return Arrays.asList(listVideo);
            } else {
                throw new RuntimeException("HTTP Error: " + response.getStatus());
            }

        } catch (Exception e) {
            return null;
        }*/
    }
    public List<Video> getVideosByTitle(String titleSearch) {
        try {
            //api call
            String jsonBody = "{\"title\":" + titleSearch + "\"}";
            Response response = targetTitle
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(jsonBody, MediaType.APPLICATION_JSON));
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Response from the Server: ");
                System.out.println(response);
                Video[] listVideo = response.readEntity(Video[].class);
                return Arrays.asList(listVideo);
            } else {
                throw new RuntimeException("HTTP Error: " + response.getStatus());
            }

        } catch (Exception e) {
            return null;
        }
    }

}

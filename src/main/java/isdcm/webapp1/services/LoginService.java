/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.webapp1.services;

import java.util.List;
import java.util.Arrays;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Iñigo
 */
public class LoginService {

    private Client client = ClientBuilder.newClient();
    private WebTarget target = client.target("http://localhost:8080/REST-video-server/resources/login");

    public String getJWT(String username, String password) {
        try {
            //api call
            //String jsonBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
            //System.out.println("json: " + jsonBody);
            String jsonBody = "{}";
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(jsonBody, MediaType.APPLICATION_JSON));
            System.out.println(response);
  
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                System.out.println("Response from the Server: ");
                System.out.println(response);
                String jwt = response.readEntity(String.class);
                return jwt;
            } else {
                throw new RuntimeException("CLIENT HTTP Error: " + response.getStatus());
            }

        } catch (Exception e) {
            System.out.println("Exception " + e);
            e.printStackTrace();
            return null;
        }
    }
}

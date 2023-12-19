package com.SCU.pose.service;

import com.SCU.pose.model.*;
import com.SCU.pose.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class PushUp_Service {
    private UserRepository userRepository;

    public void analyzePushups(Video video, int Userid){

        //initialize and fill up the pushup object
        PushUp pushup = new PushUp();

        //save the pushup object to user by userId
        User user = userRepository.findAllById(Userid);
        user.getPushups().add(pushup);

    }
    public int countPushups(Video video) {
        int pushupCount = 0;
        boolean isDown = false;

        for (Image image : video.getImages()) {
            if (isPushupDown(image)) {
                if (!isDown) {
                    isDown = true;
                }
            } else if (isDown) {
                pushupCount++;
                isDown = false;
            }
        }

        return pushupCount;
    }

    private boolean isPushupDown(Image image) {
        // Assuming the first coordinate is the right elbow and the second is the right shoulder
        Coordinate rightElbow = image.getCoordinates().get(13);
        Coordinate rightShoulder = image.getCoordinates().get(12);

        // Check if the elbow is below the shoulder
        return rightElbow.getY() > rightShoulder.getY();
    }
}

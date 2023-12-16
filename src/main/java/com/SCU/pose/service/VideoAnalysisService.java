package com.SCU.pose.service;

import com.SCU.pose.model.Video;
import com.SCU.pose.model.Image;
import com.SCU.pose.model.Coordinate;
import org.springframework.stereotype.Service;

@Service
public class VideoAnalysisService {

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

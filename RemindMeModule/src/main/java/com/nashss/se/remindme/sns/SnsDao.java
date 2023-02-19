package com.nashss.se.remindme.sns;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class SnsDao {
    private static final String REGION = "us-east-2";
    static AmazonSNS snsClient = AmazonSNSClientBuilder.standard()
            .withRegion(Regions.US_EAST_2)
            .build();

    public static void pubText(String phoneNumber, String message) {
        String topic = "arn:aws:sns:" + REGION + "arn:aws:sns:us-east-2:324797894304:RemindMeTopic";

        PublishRequest pr = new PublishRequest();
        pr.setMessage(message);
        pr.setPhoneNumber(phoneNumber);
        pr.setTopicArn(topic);

        PublishResult prs = snsClient.publish(pr);
        System.out.println("sent msg. id: " + prs.getMessageId());
    }

    public static void main(String[] args) {
        pubText("19016074800", "Balls In My Mouth");
    }
}

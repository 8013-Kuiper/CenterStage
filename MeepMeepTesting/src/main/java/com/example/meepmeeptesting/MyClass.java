package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(23, -70, Math.toRadians(90)))
                                .splineTo(new Vector2d(23,-46),Math.toRadians(90))
                                //.lineTo(new Vector2d(23,-46))
                                .waitSeconds(3)
                                //.splineToLinearHeading(new Pose2d(46,-46, Math.toRadians(0)), Math.toRadians(0))
                                .splineToSplineHeading(new Pose2d(46,-46,Math.toRadians(0)),Math.toRadians(0))
                                .splineTo(new Vector2d(49, -46),Math.toRadians(0))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}//asdf
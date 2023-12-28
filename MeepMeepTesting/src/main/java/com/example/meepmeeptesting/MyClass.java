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
                                .splineTo(new Vector2d(23, -40), Math.toRadians(90))
                                .strafeTo(new Vector2d(6.7,-40))
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{

                                })
                                .splineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)), Math.toRadians(0))
                                .splineTo(new Vector2d(49, -46), Math.toRadians(0))
                                .addDisplacementMarker(()->{

                                })
                                .strafeRight(16)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .strafeTo(new Vector2d(49,-12))
                                .back(8)
                                .build()


                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}//asdf
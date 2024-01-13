package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(750);

        RoadRunnerBotEntity myBotoppo = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5, 65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                                //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                                .lineTo(new Vector2d(51,46))
                                .addDisplacementMarker(()->{

                                })
                                .strafeLeft(3)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                //.strafeTo(new Vector2d(49,58))
                                .strafeTo(new Vector2d(51,58))
                                .back(8)
                                .build()


                );

        RoadRunnerBotEntity myBot2oppo = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5, 65, Math.toRadians(-90)))
                                //.splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                                //.strafeTo(new Vector2d(6.7,40))
                                .splineTo(new Vector2d(6.7,38),Math.toRadians(-160))
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{

                                })
                                //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                                //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                                .lineTo(new Vector2d(51,46))
                                .addDisplacementMarker(()->{

                                })
                                .strafeLeft(16)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                //.strafeTo(new Vector2d(49,58))
                                .strafeTo(new Vector2d(51,58))
                                .back(8)
                                .build()
                );

        RoadRunnerBotEntity myBot3oppo = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5, 65, Math.toRadians(-90)))
                                //.splineTo(new Vector2d(23, 35), Math.toRadians(-90))
                                //.strafeTo(new Vector2d(10,35))
                                .splineTo(new Vector2d(23,27),Math.toRadians(-160))
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{

                                })
                                //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                                //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                                .lineTo(new Vector2d(51,46))
                                .addDisplacementMarker(()->{

                                })
                                .strafeLeft(12)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{


                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{


                                })
                                //.strafeTo(new Vector2d(49,58))
                                .strafeTo(new Vector2d(51,58))
                                .back(8)
                                .build()
                );





        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5, -62, Math.toRadians(90)))
                                .splineTo(new Vector2d(23, -40), Math.toRadians(90))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                //.splineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))
                                //.splineTo(new Vector2d(51, -46), Math.toRadians(0))
                                .lineTo(new Vector2d(51,-46))
                                .addDisplacementMarker(()->{

                                })
                                .strafeRight(3)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .strafeTo(new Vector2d(51,-58))
                                .back(8)
                                .build()


                );

        RoadRunnerBotEntity myBot2 = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(14.5, -65, Math.toRadians(90)))
                                        //.splineTo(new Vector2d(23, -40), Math.toRadians(90))
                                        //.strafeTo(new Vector2d(6.7,-40))
                                        .splineTo(new Vector2d(6.7,-38),Math.toRadians(160))
                                        .addDisplacementMarker(()->{

                                        })
                                        .waitSeconds(1)
                                        .addDisplacementMarker(()->{

                                        })
                                        //.splineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)), Math.toRadians(0))
                                        .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))
                                        //.splineTo(new Vector2d(51, -46), Math.toRadians(0))
                                        .lineTo(new Vector2d(51,-46))
                                        .addDisplacementMarker(()->{

                                        })
                                        .strafeRight(16)
                                        .waitSeconds(.5)
                                        .addDisplacementMarker(()->{

                                        })
                                        .waitSeconds(.5)
                                        .addDisplacementMarker(()->{

                                        })
                                        .strafeTo(new Vector2d(51,-58))
                                        .back(8)
                                        .build()
                );


        RoadRunnerBotEntity myBot3 = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5, -65, Math.toRadians(90)))
                                //.splineTo(new Vector2d(23, -35), Math.toRadians(90))
                                .splineTo(new Vector2d(23,-27),Math.toRadians(160))
                                //.strafeTo(new Vector2d(10,-35))
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{

                                })
                                //.splineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))
                                //.splineTo(new Vector2d(49, -46), Math.toRadians(0))
                                .lineTo(new Vector2d(51,-46))
                                .addDisplacementMarker(()->{

                                })
                                .strafeRight(12)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{


                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{


                                })
                                .strafeTo(new Vector2d(51,-58))
                                .back(8)
                                .build()
                );

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        RoadRunnerBotEntity redlongbot1 = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5, -65, Math.toRadians(90)))
                                .splineTo(new Vector2d(-47, -38), Math.toRadians(90))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,-59.5), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,-59.5))

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(51,-46))

                                .addDisplacementMarker(()->{

                                })
                                .strafeRight(16)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })

                                .build()
                );

        RoadRunnerBotEntity redlongbot2 = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5, -65, Math.toRadians(90)))
                                .splineTo(new Vector2d(-29, -37.5), Math.toRadians(20))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,-59.5), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,-59.5))

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(51,-46))

                                .addDisplacementMarker(()->{

                                })
                                .strafeRight(3)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })

                                .build()
                );



        RoadRunnerBotEntity redlongbot3 = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5, -65, Math.toRadians(90)))
                                .splineTo(new Vector2d(-45,-27),Math.toRadians(20))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,-59.5), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,-59.5))

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(51,-46))

                                .addDisplacementMarker(()->{

                                })
                                .strafeRight(12)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })

                                .build()
                );


        RoadRunnerBotEntity redlongbot1oppo = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5, 65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(-47, 38), Math.toRadians(-90))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,59.5), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,59.5))

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(51,46))

                                .addDisplacementMarker(()->{

                                })
                                .strafeLeft(16)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })

                                .build()
                );

        RoadRunnerBotEntity redlongbot2oppo = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5, 65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(-29, 37.5), Math.toRadians(-20))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,59.5), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,59.5))

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(51,46))

                                .addDisplacementMarker(()->{

                                })
                                .strafeLeft(3)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })

                                .build()
                );



        RoadRunnerBotEntity redlongbot3oppo = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueLight())
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(30, 30, Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5, 65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(-45,27),Math.toRadians(-20))
                                .addDisplacementMarker(()->{
                                    //deliverPurple(100,.2);
                                })
                                .waitSeconds(1)
                                .addDisplacementMarker(()->{
                                    //resetIntake();

                                })
                                //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,59.5), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,59.5))

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(51,46))

                                .addDisplacementMarker(()->{

                                })
                                .strafeLeft(12)
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addDisplacementMarker(()->{

                                })

                                .build()
                );


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                /*.addEntity(myBot)
                .addEntity(myBot2)
                .addEntity(myBot3)
                .addEntity(myBotoppo)
                .addEntity(myBot2oppo)
                .addEntity(myBot3oppo)*/
                .addEntity(redlongbot1)
                //.addEntity(redlongbot2)
                //.addEntity(redlongbot3)
                .addEntity(redlongbot1oppo)
                //.addEntity(redlongbot2oppo)
                //.addEntity(redlongbot3oppo)
                .start();
    }
}//asdf
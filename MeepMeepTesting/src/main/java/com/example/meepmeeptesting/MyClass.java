package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MyClass {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(1200);


        RoadRunnerBotEntity bluecloseleft = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                        .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(14.5,65, Math.toRadians(-90)))
                                        .splineTo(new Vector2d(23, 40), Math.toRadians(-90))
                                        .addTemporalMarker(()->{

                                        })
                                        .waitSeconds(1)
                                        .addTemporalMarker(()->{

                                        })

                                        .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                        .lineTo(new Vector2d(50,46))
                                        .addTemporalMarker(()->{

                                        })
                                        .strafeLeft(3)
                                        .back(4.75)

                                        .waitSeconds(.5)
                                        .addTemporalMarker(()->{

                                        })
                                        .waitSeconds(2)
                                        .addTemporalMarker(()->{
                                        })

                                        .strafeTo(new Vector2d(50,66))
                                        .back(8)
                                        .waitSeconds(10)
                                        .build()
                        );

        RoadRunnerBotEntity bluecloseright = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5,65, Math.toRadians(-90)))

                                .splineTo(new Vector2d(6.7,38),Math.toRadians(-160))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(50,46))
                                .addTemporalMarker(()->{

                                })

                                .strafeLeft(17)
                                .back(4.75)
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })
                                //.strafeTo(new Vector2d(49,58))
                                .strafeTo(new Vector2d(50,66))//58
                                .back(8)
                                .waitSeconds(10)
                                .build()

                );



        RoadRunnerBotEntity blueclosecenter = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5,65, Math.toRadians(-90)))

                                .splineTo(new Vector2d(23,27),Math.toRadians(-160))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })
                                //.splineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)), Math.toRadians(0))
                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))
                                //.splineTo(new Vector2d(49, 46), Math.toRadians(0))
                                .lineTo(new Vector2d(50,46))
                                .addTemporalMarker(()->{
                                    //Crane.setTargetPosition(-2000);
                                })
                                .strafeLeft(10)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{


                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{


                                })

                                .strafeTo(new Vector2d(50,66))
                                .back(8)
                                .waitSeconds(10)
                                .build()

                );



        RoadRunnerBotEntity redcloseright = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeRedLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5,-65, Math.toRadians(90)))
                                .splineTo(new Vector2d(23, -40), Math.toRadians(90))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(50,-46))
                                .addTemporalMarker(()->{

                                })
                                .strafeRight(3)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .strafeTo(new Vector2d(50,-66))
                                .back(8)
                                .waitSeconds(10)
                                .build()
                );



        RoadRunnerBotEntity redcloseleft = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeRedLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5,-65, Math.toRadians(90)))

                                .splineTo(new Vector2d(6.7,-38),Math.toRadians(160))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(50,-46))
                                .addTemporalMarker(()->{

                                })
                                .strafeRight(17)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                //.strafeTo(new Vector2d(49,-58))
                                .strafeTo(new Vector2d(50,-66))
                                .back(8)
                                .waitSeconds(10)
                                .build()

                );


        RoadRunnerBotEntity redclosecenter = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeRedLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(14.5,-65, Math.toRadians(90)))

                                .splineTo(new Vector2d(23,-27),Math.toRadians(160))

                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(50,-46))
                                .addTemporalMarker(()->{

                                })
                                .strafeRight(10)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{


                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{


                                })
                                //.strafeTo(new Vector2d(49,-58))
                                .strafeTo(new Vector2d(50,-66))

                                .back(8)
                                .waitSeconds(10)
                                .build()

                );



        RoadRunnerBotEntity bluelongleft = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5,65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(-29, 37.5), Math.toRadians(-20))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{


                                })
                                //.lineToSplineHeading(new Pose2d(-35,-60.5, Math.toRadians(0)))
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,62), Math.toRadians(0))//59.5
                                .setReversed(false)
                                .waitSeconds(5)

                                .lineToConstantHeading(new Vector2d(11,62))//59.6

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(50,46))

                                .addTemporalMarker(()->{

                                })
                                .strafeLeft(3)

                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(10)

                                .build()
                );



        RoadRunnerBotEntity bluelongright = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5,65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(-47, 38), Math.toRadians(-90))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,62), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,62))

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(50,46))

                                .addTemporalMarker(()->{

                                })
                                .strafeLeft(17)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{


                                })
                                .waitSeconds(10)
                                .build()

                );



        RoadRunnerBotEntity bluelongcenter = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeBlueLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5,65, Math.toRadians(-90)))
                                .splineTo(new Vector2d(-45,27),Math.toRadians(-20))
                                .addTemporalMarker(()->{


                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{

                                })

                                .setReversed(true)
                                .splineTo(new Vector2d(-37,62), Math.toRadians(0))//go in front of truss
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,62))

                                .lineToSplineHeading(new Pose2d(46, 46, Math.toRadians(-180)))

                                .lineTo(new Vector2d(50,46))

                                .addTemporalMarker(()->{

                                })
                                .strafeLeft(10)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(10)
                                .build()
                );



        RoadRunnerBotEntity redlongright = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeRedLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5,-65, Math.toRadians(90)))
                                .splineTo(new Vector2d(-29, -37.5), Math.toRadians(20))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{


                                })

                                .setReversed(true)
                                .splineTo(new Vector2d(-37,-62), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)

                                .lineToConstantHeading(new Vector2d(11,-62))

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(50,-46))

                                .addTemporalMarker(()->{

                                })
                                .strafeRight(3)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(10)
                                .build()
                );



        RoadRunnerBotEntity redlongleft = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeRedLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5,-65, Math.toRadians(90)))
                                .splineTo(new Vector2d(-47, -38), Math.toRadians(90))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{


                                })
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,-62), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,-62))

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(50,-46))

                                .addTemporalMarker(()->{

                                })
                                .strafeRight(17)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(10)
                                .build()

                );



        RoadRunnerBotEntity redlongcenter = new DefaultBotBuilder(meepMeep)
                .setConstraints(30,30,Math.toRadians(139.76083890256965), Math.toRadians(60), 18.52)
                .setColorScheme(new ColorSchemeRedLight())
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.5,-65, Math.toRadians(90)))
                                .splineTo(new Vector2d(-45,-27),Math.toRadians(20))
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(1)
                                .addTemporalMarker(()->{


                                })
                                .setReversed(true)
                                .splineTo(new Vector2d(-37,-62), Math.toRadians(0))
                                .setReversed(false)
                                .waitSeconds(5)
                                .lineToConstantHeading(new Vector2d(11,-62))

                                .lineToSplineHeading(new Pose2d(46, -46, Math.toRadians(180)))

                                .lineTo(new Vector2d(50,-46))

                                .addTemporalMarker(()->{

                                })
                                .strafeRight(10)
                                .back(4.75)

                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(.5)
                                .addTemporalMarker(()->{

                                })
                                .waitSeconds(10)
                                .build()

                );


        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                /*.addEntity(bluecloseleft)
                .addEntity(bluecloseright)
                .addEntity(blueclosecenter)*/
                .addEntity(bluelongleft)
                .addEntity(bluelongright)
                .addEntity(bluelongcenter)
                /*.addEntity(redlongright)
                .addEntity(redlongleft)
                .addEntity(redlongcenter)
                .addEntity(redcloseright)
                .addEntity(redcloseleft)
                .addEntity(redclosecenter)*/
                .start();
    }
}//asdf
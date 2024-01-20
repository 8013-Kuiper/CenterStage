package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;


public abstract class driveConstant extends LinearOpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;                                         //Declaring Motor varibles
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor Crane;

    public DcMotor Intake;

    public DcMotor Winch;

    //public OpenCvCamera webcam;

    public Servo leftServo;

    public Servo Plane;

    public Servo rightServo;

    public Servo springArm;

    public Servo armHolder;

    public Servo dropoff;



    public void initrobot() {




        Crane = hardwareMap.get(DcMotor.class,"crane");

        Intake = hardwareMap.get(DcMotor.class, "intake");

        leftServo = hardwareMap.get(Servo.class, "leftServo");

        rightServo = hardwareMap.get(Servo.class, "rightServo");

        Winch = hardwareMap.get(DcMotor.class, "Winch");

        Plane = hardwareMap.get(Servo.class, "plane");

        springArm = hardwareMap.get(Servo.class, "springarm");

        armHolder = hardwareMap.get(Servo.class, "armHolder");

        dropoff = hardwareMap.get(Servo.class, "dropoff");


        Crane.setDirection(DcMotorSimple.Direction.FORWARD);
        Crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Crane.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }
    public void initdrivetrain(){
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");                            //mapping motors from control hub
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);                 //setting direction of drive train
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }



    //methods
    public void deliverPurple(int pos, double power){
        Intake.setTargetPosition(pos);
        Intake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Intake.setPower(power);
    }
    public void activate(){
        Intake.setPower(1);
    }
    public void deactivate(){
        Intake.setPower(0);
    }

    public void resetIntake(){
        Intake.setTargetPosition(0);
        Intake.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Intake.setPower(1);
    }
    public void extend(){
        Crane.setTargetPosition(-2290);
        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Crane.setPower(1);
    }

    public void retract(){
        Crane.setTargetPosition(-10);
        Crane.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Crane.setPower(1);
    }

    public void drop(){
        rightServo.setPosition(1);
    }

}

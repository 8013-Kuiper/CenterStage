package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.openftc.easyopencv.OpenCvCamera;


public abstract class driveConstant extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;                                         //Declaring Motor varibles
    public DcMotor backLeft;
    public DcMotor backRight;

    public DcMotor Crane;

    public DcMotor Intake;

    public DcMotor Winch;

    public OpenCvCamera webcam;

    public Servo leftServo;

    public Servo Plane;

    public Servo rightServo;

    public Servo springArm;

    public Servo armHolder;


    public void initrobot() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");                            //mapping motors from control hub
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");



        Crane = hardwareMap.get(DcMotor.class,"crane");

        Intake = hardwareMap.get(DcMotor.class, "intake");

        leftServo = hardwareMap.get(Servo.class, "leftServo");

        rightServo = hardwareMap.get(Servo.class, "rightServo");

        Winch = hardwareMap.get(DcMotor.class, "Winch");

        Plane = hardwareMap.get(Servo.class, "plane");

        springArm = hardwareMap.get(Servo.class, "springarm");

        armHolder = hardwareMap.get(Servo.class, "armHolder");



        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);                 //setting direction of drive train
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);


        Crane.setDirection(DcMotorSimple.Direction.FORWARD);
        Crane.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Crane.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Crane.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }
}

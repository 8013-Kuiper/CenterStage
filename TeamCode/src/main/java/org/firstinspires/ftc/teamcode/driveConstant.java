package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
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


    //public OpenCvCamera webcam;

    public CRServo leftServo;

    public Servo Plane;

    public CRServo rightServo;

    public Servo winch;

    public Servo outTake;

    public DcMotor arm;


    public void initrobot() {


        winch = hardwareMap.get(Servo.class, "Winch");

        outTake = hardwareMap.get(Servo.class, "outTake");

        leftServo = hardwareMap.get(CRServo.class, "leftServo");

        rightServo = hardwareMap.get(CRServo.class, "rightServo");

        Plane = hardwareMap.get(Servo.class, "plane");

        arm = hardwareMap.get(DcMotor.class, "Arm");


        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        //arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //Crane.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }

    public void initdrivetrain() {
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
    public void moveArm(double power, int position){
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setTargetPosition(position);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(power);

    }

    public double servoPos(double armPos, double encoderRange){
        double ratio = 1/encoderRange;

        if (gamepad2.left_trigger>1){
            return .7;
        }

        else {
            double pos = ratio*armPos;
            return pos;
        }

    }
}



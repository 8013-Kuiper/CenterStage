package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.openftc.easyopencv.OpenCvCamera;


public abstract class DriveConstants extends OpMode {

    public DcMotor frontLeft;
    public DcMotor frontRight;                                         //Declaring Motor varibles
    public DcMotor backLeft;
    public DcMotor backRight;


    public DcMotor lights;
    public CRServo Left;
    public DcMotor Crain;
    public DcMotor Spin;
    public Servo Guide;

    public OpenCvCamera webcam;

    private Rev2mDistanceSensor distance;

    public void initrobot() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");                            //mapping motors from control hub
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");



        //Crain = hardwareMap.get(DcMotor.class, "Crane");

       // distance = hardwareMap.get(Rev2mDistanceSensor.class, "distance");
       // lights = hardwareMap.get(DcMotor.class, "Lights");

        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);                 //setting direction of drive train
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);


        Crain.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Crain.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Spin.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Spin.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }
}

package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "Michael - Auto. Park Glyph Left", group = "Autonomous")
public class AutoParkWithGlyph extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private Servo armclaw;
    private DcMotor armmotor;
    private int targetposition;
    double ARMCLOSE= 0.28;
    double ARMOPEN= ARMCLOSE-0.23;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        armclaw = hardwareMap.servo.get("armclaw");
        leftmotor.setDirection(DcMotor.Direction.REVERSE);
        armmotor = hardwareMap.dcMotor.get("arm");

        waitForStart();
        CloseServo();
        LiftSlide(2, "sec");
        Drive4ward(3);
        turnLeft(3);
        Drive4ward(4);
        stopDrive(ZERO_SPEED, 300);
        OpenServo();
        Drive4ward(1);


    }
    double DRIVE_POWER = -.5;
    double ZERO_SPEED = 00.00;

    public void CloseServo(){
        armclaw.setPosition(ARMCLOSE);
    }
    public void LiftSlide(int time, String fam) throws InterruptedException {
        armmotor.setPower(1);
        Thread.sleep(time*1000);
    }
    public void OpenServo(){
        armclaw.setPosition(ARMOPEN);
    }
    public void Drive4ward(int rotations) throws InterruptedException {
        leftmotor.setTargetPosition(1440 * rotations);
        rightmotor.setTargetPosition(1440 * rotations);
    }
    public void turnLeft(int rotations) throws InterruptedException {
        leftmotor.setTargetPosition(-1440 * rotations);
        rightmotor.setTargetPosition(1440 * rotations);
    }

    public void turnRight(int rotations) throws InterruptedException {
        leftmotor.setTargetPosition(1440 * rotations);
        rightmotor.setTargetPosition(-1440 * rotations);

    }
    public void stopDrive(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
}
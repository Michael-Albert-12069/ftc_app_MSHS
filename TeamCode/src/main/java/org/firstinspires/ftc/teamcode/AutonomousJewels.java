package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "Michael - Auto. Park", group = "Autonomous")
public class AutonomousJewels extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private int targetposition;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        Drive4ward(DRIVE_POWER, 750);
        turnLeft(DRIVE_POWER, 500);
        Drive4ward(DRIVE_POWER, 500);
        stopDrive(ZERO_SPEED, 300);

    }
    double DRIVE_POWER = -.75;
    double ZERO_SPEED = 00.00;

    public void Drive4ward(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);

    }
    public void turnLeft(double power, long time) throws InterruptedException {
        leftmotor.setPower(-power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
    public void turnRight(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(-power);
        Thread.sleep(time);
    }
    public void stopDrive(double power, long time) throws InterruptedException {
        leftmotor.setPower(power);
        rightmotor.setPower(power);
        Thread.sleep(time);
    }
}
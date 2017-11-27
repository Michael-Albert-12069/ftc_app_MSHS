package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by michaelalbert on 10/14/17.
 */
@Autonomous(name = "Michael - Auto Test", group = "Autonomous")
public class AutonomousEncoderTest extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;
    private int targetposition;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");
        leftmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightmotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        boolean leftmotorbusy;
        boolean rightmotorbusy;

        leftmotor.setDirection(DcMotor.Direction.REVERSE);
        int leftcurrentposition;
        int rightcurrentposition;

        waitForStart();

        for(int l=0; l<=5; l++){
            rightcurrentposition = rightmotor.getCurrentPosition();
            leftcurrentposition = leftmotor.getCurrentPosition();

            leftmotor.setTargetPosition(leftcurrentposition + 25);
            leftmotorbusy = leftmotor.isBusy();
            rightmotor.setTargetPosition(rightcurrentposition + 25);
            rightmotorbusy = rightmotor.isBusy();
            while ((leftmotorbusy == true) || (rightmotorbusy == true)){
                Thread.sleep(100);
                rightmotorbusy = rightmotor.isBusy();
                leftmotorbusy = leftmotor.isBusy();
            }

        }


    }

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
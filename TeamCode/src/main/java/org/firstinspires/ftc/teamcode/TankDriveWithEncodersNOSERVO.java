package org.firstinspires.ftc.teamcode;

/**
 * Created by michaelalbert on 10/15/17.
 */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by michaelalbert on 10/14/17.
 */
@TeleOp(name = "Michael - TeleOp Tank", group = "TeleOp")
//@Disabled
public class TankDriveWithEncodersNOSERVO extends LinearOpMode {
    private DcMotor leftmotor;
    private DcMotor rightmotor;

    @Override
    public void runOpMode() throws InterruptedException {

        leftmotor = hardwareMap.dcMotor.get("leftmotor");
        rightmotor = hardwareMap.dcMotor.get("rightmotor");


        leftmotor.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();
        while ((opModeIsActive())) {
            //servo left max= 0; close = 140
            //servo right max= 145; close = 0
double leftpower = gamepad1.left_stick_y/2;
            double rightpower = gamepad1.right_stick_y/2;


 /*           motorRight.setPower(right);
            motorLeft.setPower(left);
       //     Before this you have to make sure to “clip” the joystick values to they never go above 1 and below -1, because those are the only value range that the motors now take.  To do this:
// clip the right/left values so that the values never exceed +/- 1
            right = Range.clip(right, -1, 1);
            left = Range.clip(left, -1, 1); **/

                 leftmotor.setPower(leftpower);
                 rightmotor.setPower(rightpower);

            telemetry.update();
            idle();
        }
    }
}
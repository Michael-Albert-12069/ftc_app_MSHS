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
@TeleOp(name = "Michael - TeleOp Tank ServoTEST", group = "TeleOp")
//@Disabled
public class SERVOTEST extends LinearOpMode {

    private Servo armclaw;

    @Override
    public void runOpMode() throws InterruptedException {

        armclaw = hardwareMap.servo.get("armclaw");



        waitForStart();
        while ((opModeIsActive())) {
            //servo left max= 0; close = 140
            //servo right max= 145; close = 0

            double currentposition = armclaw.getPosition();

            if(gamepad2.a){
//            open
                armclaw.setPosition(0.00);
            }else {
//            close
                if (gamepad2.b) {
                    armclaw.setPosition(0.28);
                }
            }



 /*           motorRight.setPower(right);
            motorLeft.setPower(left);
       //     Before this you have to make sure to “clip” the joystick values to they never go above 1 and below -1, because those are the only value range that the motors now take.  To do this:
// clip the right/left values so that the values never exceed +/- 1
            right = Range.clip(right, -1, 1);
            left = Range.clip(left, -1, 1); **/


        //this build team is crap, pls help

            currentposition = armclaw.getPosition();
            String currentpos = Double.toString(currentposition);
            telemetry.addLine(currentpos);
            telemetry.update();
            idle();
        }
    }
}
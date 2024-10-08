package frc.robot;

import frc.robot.huskylib.src.*;
import frc.robot.huskylib.src.WestCoastDriveTrain;
import frc.robot.huskylib.src.RoboDevice;

public class SpiritRobotChassis extends RoboDevice{

  private WestCoastDriveTrain m_driveTrain = 
    new WestCoastDriveTrain(  WiringConnections.LEFT_MAIN_CONTROLLER_ID,
                              WiringConnections.LEFT_FOLLOW_1_CONTROLLER_ID,
                              WiringConnections.LEFT_FOLLOW_2_CONTROLLER_ID,
                              WiringConnections.RIGHT_MAIN_CONTROLLER_ID,
                              WiringConnections.RIGHT_FOLLOW_1_CONTROLLER_ID,
                              WiringConnections.RIGHT_FOLLOW_2_CONTROLLER_ID
                           );

  private HuskyVector2D m_currentLocation;
  private double m_currentHeading = 0.0;
  private HuskyVector2D m_currentVelocity;

  public SpiritRobotChassis(){
    super("FRC2023Chassis");

    AddChildDevice(m_driveTrain);

    m_currentLocation = new HuskyVector2D();
    m_currentVelocity = new HuskyVector2D();
  }

  public void Initialize(){
    m_driveTrain.Initialize();
  }

  public void setTargForwardBack(double targFB){
    m_driveTrain.setTargSpeed(targFB);
  }

  public void setTargRotation(double targRot){
    m_driveTrain.setTargRotationSpeed(targRot);
  }

  public void driveStraight(){
    setTargForwardBack(0.4);
    setTargRotation(0.0);
  }

  @Override
  public void doGatherInfo() {
    super.doGatherInfo();

    m_currentVelocity.setVals(0.0, m_driveTrain.getCurrentSpeed());
    m_currentVelocity.rotate(m_currentHeading);

    m_currentLocation.addVec(m_currentVelocity);
  }



  public HuskyVector2D getCurrentLocation(){
    return m_currentLocation;
  }

  public HuskyVector2D getCurrentVelocity(){
    return m_currentVelocity;
  }

  public double getCurrentHeading(){
    return m_currentHeading;
  }


  @Override
  public void doActions() {
    super.doActions();
  }

}

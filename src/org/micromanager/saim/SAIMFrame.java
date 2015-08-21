/**
 * SAIMFrame.java
 *
 *
 * This is a Micro-Manager plugin for using a Scanning Angle Interference 
 * Microscopy calibration device. This specific example uses the NetBeans GUI 
 * builder. It is based on ExampleFrame.java
 *
 *
 * Nico Stuurman, copyright Regents of the University of California, 2012
 * Kate Carbone, 2015
 *
 * LICENSE: This file is distributed under the BSD license. License text is
 * included with the source distribution.
 *
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE.
 *
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.
 */
package org.micromanager.saim;

import mmcorej.CMMCore;

import java.text.NumberFormat;

import java.util.prefs.Preferences;

import org.micromanager.api.ScriptInterface;

import org.jfree.data.xy.XYSeries;
import mmcorej.DeviceType;
import mmcorej.StrVector;
import org.micromanager.saim.fit.Fitter;
import org.micromanager.saim.plot.PlotUtils;
import java.text.DecimalFormat;

/**
 *
 * @author nico
 */
public class SAIMFrame extends javax.swing.JFrame {

    private final ScriptInterface gui_;
    private final CMMCore core_;
    private final Preferences prefs_;

    private final NumberFormat nf_;

    private final int frameXPos_ = 100;
    private final int frameYPos_ = 100;

    private static final String FRAMEXPOS = "FRAMEXPOS";
    private static final String FRAMEYPOS = "FRAMEYPOS";

    /**
     * Constructor
     *
     * @param gui - Reference to MM script interface
     */
    public SAIMFrame(ScriptInterface gui) {
        gui_ = gui;
        core_ = gui_.getMMCore();
        nf_ = NumberFormat.getInstance();
        prefs_ = Preferences.userNodeForPackage(this.getClass());

        initComponents();
        //Guess Zero Motor Position
        jTextField3.setText("30000");        
        //Start Motor Position
        jTextField4.setText("22000");
        //End Motor Position
        jTextField2.setText("41000");
        //Number of Calibration Points
        jTextField1.setText("100");
        //Set toggle button to run (vs. "Abort")
        jToggleButton1.setText("Run");
        jLabel7.setText(null);
        jLabel15.setText(null);
        //Calibration Output
        StrVector serialPorts = core_.getLoadedDevicesOfType(DeviceType.SerialDevice);
        for (int i = 0; i < serialPorts.size(); i++) {
            jComboBox1.addItem(serialPorts.get(i));
        }
        StrVector genericPorts = core_.getLoadedDevicesOfType(DeviceType.GenericDevice);
        for (int i = 0; i < genericPorts.size(); i++) {
            jComboBox2.addItem(genericPorts.get(i));
        }
        StrVector stagePorts = core_.getLoadedDevicesOfType(DeviceType.StageDevice);
        for (int i = 0; i < stagePorts.size(); i++) {
            jComboBox2.addItem(stagePorts.get(i));
        }
        setLocation(frameXPos_, frameYPos_);

        setBackground(gui_.getBackgroundColor());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jTextField2 = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();
      jComboBox1 = new javax.swing.JComboBox();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jTextField4 = new javax.swing.JTextField();
      jLabel7 = new javax.swing.JLabel();
      jTextField1 = new javax.swing.JTextField();
      jLabel8 = new javax.swing.JLabel();
      jLabel9 = new javax.swing.JLabel();
      jComboBox2 = new javax.swing.JComboBox();
      jLabel10 = new javax.swing.JLabel();
      jTextField3 = new javax.swing.JTextField();
      jLabel11 = new javax.swing.JLabel();
      jLabel12 = new javax.swing.JLabel();
      jLabel13 = new javax.swing.JLabel();
      OKButton_1 = new javax.swing.JButton();
      jLabel14 = new javax.swing.JLabel();
      jLabel15 = new javax.swing.JLabel();
      jToggleButton1 = new javax.swing.JToggleButton();

      setTitle("SAIM Plugin");
      setLocationByPlatform(true);
      setResizable(false);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            onWindowClosing(evt);
         }
      });

      jLabel1.setText("SAIM Calibration");

      jLabel2.setText("Run Calibration: ");

      jLabel3.setText("Start Motor Position: ");

      jTextField2.setText("jTextField2");
      jTextField2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField2ActionPerformed(evt);
         }
      });

      jLabel4.setText("End Motor Position: ");

      jComboBox1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
         }
      });

      jLabel5.setText("Select Serial Port: ");

      jLabel6.setText("Polynomial Fit: ");

      jTextField4.setText("jTextField4");

      jLabel7.setText("jLabel7");
      jLabel7.setAutoscrolls(true);

      jTextField1.setText("jTextField1");

      jLabel8.setText("Number of Calibration Steps:");

      jLabel9.setText("Select TIRF Motor: ");

      jComboBox2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox2ActionPerformed(evt);
         }
      });

      jLabel10.setText("Set 0 Deg. Motor Position:");

      jTextField3.setText("jTextField3");
      jTextField3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField3ActionPerformed(evt);
         }
      });

      jLabel11.setText("Calibrate");

      jLabel12.setText("Setup");

      jLabel13.setText("Calculate Offset:");

      OKButton_1.setText("OK");
      OKButton_1.setAlignmentX(0.5F);
      OKButton_1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            OKButton_1ActionPerformed(evt);
         }
      });

      jLabel14.setText("Detector Offset:");

      jLabel15.setText("jLabel15");

      jToggleButton1.setText("jToggleButton1");
      jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jToggleButton1ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(196, 196, 196)
                  .addComponent(jLabel11))
               .addGroup(layout.createSequentialGroup()
                  .addGap(206, 206, 206)
                  .addComponent(jLabel12)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addGroup(layout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                  .addGap(40, 40, 40))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                           .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                 .addComponent(jLabel4)
                                 .addComponent(jLabel8)
                                 .addComponent(jLabel3))
                              .addGap(90, 90, 90))
                           .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                              .addComponent(jLabel10)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jTextField3)
                           .addComponent(jTextField2)
                           .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                     .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OKButton_1))
                     .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jLabel5)
                           .addComponent(jLabel9))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                           .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                     .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                  .addGap(40, 40, 40))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(134, 134, 134))
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel14)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel15)
                  .addGap(87, 87, 87))))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(jLabel1)
            .addGap(20, 20, 20)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel5))
                  .addGap(5, 5, 5)
                  .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel10))
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel13)
               .addComponent(OKButton_1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel14)
               .addComponent(jLabel15))
            .addGap(20, 20, 20)
            .addComponent(jLabel11)
            .addGap(10, 10, 10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel8))
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(jToggleButton1))
            .addGap(39, 39, 39)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(jLabel7))
            .addGap(40, 40, 40))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    /**
     * When window closes, take the opportunity to save settings to Preferences
     *
     * @param evt
     */
    private void onWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowClosing
        prefs_.putInt(FRAMEXPOS, (int) getLocation().getX());
        prefs_.putInt(FRAMEYPOS, (int) getLocation().getY());

    }//GEN-LAST:event_onWindowClosing

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void OKButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButton_1ActionPerformed
        // TODO add your handling code here:
        RunOffsetCalc();
    }//GEN-LAST:event_OKButton_1ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton1.isSelected()) {
            jToggleButton1.setText("Abort");
            RunCalibration();
        } else {
            jToggleButton1.setText("Run");
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton OKButton_1;
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JComboBox jComboBox2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel11;
   private javax.swing.JLabel jLabel12;
   private javax.swing.JLabel jLabel13;
   private javax.swing.JLabel jLabel14;
   private javax.swing.JLabel jLabel15;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JTextField jTextField1;
   private javax.swing.JTextField jTextField2;
   private javax.swing.JTextField jTextField3;
   private javax.swing.JTextField jTextField4;
   private javax.swing.JToggleButton jToggleButton1;
   // End of variables declaration//GEN-END:variables

   private void RunOffsetCalc() {
      final int zeroPos = Integer.parseInt(jTextField3.getText());
      try {
         core_.setShutterOpen(true);
         detectorMeans offsetVal = takeSnapshot(zeroPos, "Offset Scan");
         core_.setShutterOpen(false);
         if (offsetVal != null) {
            Double offset = offsetVal.getDect1() - offsetVal.getDect2();
            ij.IJ.log("Detector offset: " + offset + "\n");
            jLabel15.setText("" + offset);
         }
      } catch (Exception ex) {
         ij.IJ.log(ex.getMessage() + ", Failed to open/close the shutter");
      }
   }
   
   private void RunCalibration() {
        // Edit these variables
        final int startPosition = Integer.parseInt(jTextField4.getText());
        final int endPosition = Integer.parseInt(jTextField2.getText());
        final int nrAngles = Integer.parseInt(jTextField1.getText());
        final int angleStepSize = (endPosition - startPosition)/nrAngles;
        final String port = jComboBox1.getSelectedItem().toString();
        final String deviceName = jComboBox2.getSelectedItem().toString();
        final String propName = "Position";

        class calThread extends Thread {

            calThread(String threadName) {
                super(threadName);
            }

            @Override
            public void run() {
                int i = 0;
                try {
                    //Take image of laser position
                    XYSeries dect1gaussianMeans = new XYSeries(new Double(nrAngles), false, true);
                    XYSeries dect2gaussianMeans = new XYSeries(new Double(nrAngles), false, true);
                    core_.setShutterOpen(true);
                    int pos = startPosition;
                    for (int angle = 0; angle <= nrAngles; angle++) {
                        detectorMeans laserPos = takeSnapshot(pos, "Saim Scan");
                        if (laserPos != null) {
                                dect1gaussianMeans.add(pos, laserPos.getDect1());
                                dect2gaussianMeans.add(pos, laserPos.getDect2());
                                pos = pos + angleStepSize;
                        }
                    }
                    //Read offset if calculated
                    Double detectorOffset;
                    if ((jLabel15.getText()) != null){
                        detectorOffset = Double.parseDouble(jLabel15.getText());
                    } else { detectorOffset = 0.0;
                    }
                    //Determine True angle of laser light at each motor position
                    XYSeries trueAngles = new XYSeries("angles", false, true);
                    for (int l = 0; l <= nrAngles; l++) {
                        Double motorPosition = dect1gaussianMeans.getX(l).doubleValue();
                        Double dect1val = dect1gaussianMeans.getY(l).doubleValue();
                        Double dect2val = dect2gaussianMeans.getY(l).doubleValue() + detectorOffset;
                        //pixel center to center distance is 63.5 um
                        double xdisp = (dect1val.floatValue() - dect2val.floatValue())*0.0635;
                        //detector1 center to detector2 center is 20.64 mm
                        double ydisp = 20.64;
                        Double trueAngle = Math.toDegrees(Math.atan(xdisp/ydisp));
                        trueAngles.add(motorPosition, trueAngle);
                    }
                    PlotUtils myPlotter2 = new PlotUtils(prefs_);
                    double[] calCurve = Fitter.fit(trueAngles, Fitter.FunctionType.Pol2, null);
                    XYSeries[] toPlot = new XYSeries[2];
                    toPlot[0] = trueAngles;
                    toPlot[1] = Fitter.getFittedSeries(toPlot[0], Fitter.FunctionType.Pol2, calCurve);
                    boolean[] showShapes = {true, false};
                    myPlotter2.plotDataN("Calibration Curve", toPlot, "Position", "True Angle", showShapes, "");

                    String coeff1 = new DecimalFormat("#.##").format(calCurve[0]);
                    String coeff2 = new DecimalFormat("#.##").format(calCurve[1]); 
                    String offset = new DecimalFormat("#.##").format(calCurve[2]); 
                    jLabel7.setText("y = " + coeff1 + "* x^2 + " + coeff2 + "x + " + offset);
                    
                } catch (Exception ex) {
                   ex.printStackTrace();
                    ij.IJ.log(ex.getMessage() + "\nRan until # " + i);
                } finally {
                   try {
                    core_.setShutterOpen(false);  
                   } catch (Exception ex) {
                      ij.IJ.log(ex.getMessage());
                   };
                   jToggleButton1.setText("Run");
                   jToggleButton1.setSelected(false);
                }
            }
        }
        calThread calt = new calThread("SAIM Callibration");
        calt.start();
    }
    
    //
    final private class detectorMeans {
        private final double dect1;
        private final double dect2;

        public detectorMeans(double dect1, double dect2) {
            this.dect1 = dect1;
            this.dect2 = dect2;
        }

        public double getDect1() {
            return dect1;
        }

        public double getDect2() {
            return dect2;
        }
    }
    
    //main class code
    private detectorMeans takeSnapshot(int pos, String plotTitle) {
        int i = 0;
        try {
            final String port = jComboBox1.getSelectedItem().toString();
            final String deviceName = jComboBox2.getSelectedItem().toString();
            final String propName = "Position";
            XYSeries dect1readings = new XYSeries("upper", false, true);
            XYSeries dect2readings = new XYSeries("lower", false, true);
            core_.setProperty(deviceName, propName, pos);
            core_.waitForDevice(deviceName);
            core_.setSerialPortCommand(port, "1", "");
            ij.IJ.log("Pos: " + pos);
            for (i = 0; i < 1536; i++) {
                //ReportingUtils.logMessage("" + i);
                String answer = core_.getSerialPortAnswer(port, "\n");
                String[] vals = answer.trim().split("\\t");
                if (vals.length == 2) {
                    int dect1px = Integer.valueOf(vals[0]);
                    int dect2px = Integer.valueOf(vals[1]);
                    dect1readings.add(i, dect1px);
                    dect2readings.add(i, dect2px);
                } else {
                    System.out.println("Val is not 2: " + answer);
                }
            }
            core_.getSerialPortAnswer(port, "\n");
            
            //shuffle values of detector 1 to match physical layout of pixels
            int size = dect1readings.getItemCount();
            XYSeries dect1readingsFlip = new XYSeries("upper", false, true);
            for (int a = 0; a < size; a++) {
                Number pxvalue = dect1readings.getY(size - 1 - a);
                dect1readingsFlip.add(a, pxvalue);
            }

            PlotUtils myPlotter = new PlotUtils(prefs_);
            XYSeries[] toPlot = new XYSeries[4];
            toPlot[0] = dect1readingsFlip;
            toPlot[1] = dect2readings;
            boolean[] showShapes = {true, true, false, false};
            
            //Fit result to a gaussian
            double[] result1 = Fitter.fit(dect1readingsFlip, Fitter.FunctionType.Gaussian, null);
            toPlot[2] = Fitter.getFittedSeries(dect1readingsFlip, Fitter.FunctionType.Gaussian, result1);
            ij.IJ.log("Dectector 1 Mean: " + result1[1] + "\n");
            double[] result2 = Fitter.fit(dect2readings, Fitter.FunctionType.Gaussian, null);
            toPlot[3] = Fitter.getFittedSeries(dect2readings, Fitter.FunctionType.Gaussian, result2);
            ij.IJ.log("Dectector 2 Mean: " + result2[1] + "\n");
           
            myPlotter.plotDataN(plotTitle, toPlot, "Pixel", "Intensity", showShapes, "Pos: " + pos);
            
            
            return new detectorMeans(result1[1], result2[1]);
            
        } catch (Exception ex) {
            ij.IJ.log(ex.getMessage() + "\nRan until # " + i);
        }
        return null;
    }
}

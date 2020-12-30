/*  JAVA Slutuppgift dec 2020, GritAcademy
 * I created a new class(GUImenu.java) to extend the superclass(GUI.java). In
 * GUImenu, I added different classes such as JFrame, JLabel and JButton among
 * others. After making the frame, the components are added to it. These
 * components are then what makes the frame behave, function and appear as it does. The buttons I
 * made are used in the actionPerformed(action event e) method on row 95 in
 * GUImenu.java. The buttons are given their functions in the other class called
 * ImageEdit.java, which is called within the actionevent method. The
 * JFileChooser and JFile classes are used to give the user the choice of
 * selection of an image to edit. This image is then edited by rotation, color
 * to grayscale and changing the size of it. This is done by calling the
 * origImage that is set from the JFileChooser, JFile and buttonLoadImage
 * methods and using the image within the three other buttons, buttonRotate,
 * buttonColor and buttonResize.
 */
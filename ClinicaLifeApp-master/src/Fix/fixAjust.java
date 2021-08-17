package Fix;

import view.consulta.BuscarConsulta;

public class fixAjust {
	public static void fix() {
		 try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(BuscarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	}
	
	
}

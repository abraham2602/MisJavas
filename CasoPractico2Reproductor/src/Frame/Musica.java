package Frame;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica {

	static boolean estaSonando = false;
	static boolean estaPausada = true;
	static String[] wavs = { "1", "2" };
	String wav = "0";
	static File ruta = new File("musica\\" + wavs[0] + ".wav");	
	static AudioInputStream audio;
	static Clip pista;
	long momentoPausa;

	public void reproducir() {
		if (ruta.exists()) {

			if (estaSonando == false) {
				try {
					audio = AudioSystem.getAudioInputStream(ruta);
					pista = AudioSystem.getClip();
					pista.open(audio);
					pista.start();
					estaSonando = true;

				} catch (Exception ae) {
					ae.printStackTrace();
				}
			} else if (estaPausada == true) {
				pista.setMicrosecondPosition(momentoPausa);
				pista.start();
				estaPausada = false;
			}

		}
	}

	public void parar() {

		if (estaSonando == true) {
			
			try {
				pista.stop();
				estaSonando = false;

			} catch (Exception ae) {
				ae.printStackTrace();
			}
			
		} else {
			
		}

	}

	public void pause() {

		if (estaSonando == true) {
			momentoPausa = pista.getMicrosecondPosition();
			pista.stop();
			estaPausada = true;
		}

	}

	public void paTras() {
		ruta = new File("musica\\" + wavs[0] + ".wav");
		wav = "1";
	}

	public void paLante() {
		ruta = new File("musica\\" + wavs[1] + ".wav");
		wav = "2";

	}

}

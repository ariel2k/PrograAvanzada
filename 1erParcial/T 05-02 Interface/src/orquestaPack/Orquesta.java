package orquestaPack;

import java.util.LinkedList;
import java.util.List;

public class Orquesta {
	
	private List<Instrumento> orquesta = new LinkedList<Instrumento>();
	private List<Instrumento> vientos = new LinkedList<Instrumento>();
	private List<Instrumento> cuerdas = new LinkedList<Instrumento>();	
	
	public void agregar(Cuerda c) {
		orquesta.add(c);
		cuerdas.add(c);
	}
	
	public void agregar(Viento v) {
		orquesta.add(v);
		vientos.add(v);
	}
	
	public void tocar() {
		for(Instrumento i: orquesta){
			i.tocar();
		}
	}
	
	public void tocarVientos() {
		//Opcion 1
		for(Instrumento i: vientos){
			i.tocar();
		}
		
		//Opcion 2
		/*
		for(Instrumento i: orquesta){
			if(i instanceof Viento)
				i.tocar();
		}*/
	}
	
	public void tocarCuerdas() {
		//Opcion 1
		/*
		for(Instrumento i: cuerdas){
			i.tocar();
		}
		*/
		
		//Opcion 2		
		for(Instrumento i: orquesta){
			if(i instanceof Cuerda)
				i.tocar();
		}
	}
	
	public void afinarInstrumentos() {
		for(Instrumento i: orquesta){
			if(i instanceof Afinable)
				((Afinable) i).afinar();
		}
	}
	
	public static void main(String[] args) {
		Orquesta o = new Orquesta();
		CGuitarra guitarra = new CGuitarra();
		CBajo bajo = new CBajo();
		VFlauta flauta = new VFlauta();
		VSaxo saxo = new VSaxo();
		CViolin violin = new CViolin();
		VTrompeta trompeta = new VTrompeta();
		
		o.agregar(guitarra);
		o.agregar(bajo);
		o.agregar(flauta);
		o.agregar(saxo);
		o.agregar(violin);
		o.agregar(trompeta);
		
		System.out.println("--------Tocar toda la banda--------");
		o.tocar();
		System.out.println("\n--------Tocar solo vientos --------");
		o.tocarVientos();
		System.out.println("\n--------Tocar solo cuerdas --------");		
		o.tocarCuerdas();
		System.out.println("\n--------Afinar Instrumentos--------");
		o.afinarInstrumentos();
	}
	
}

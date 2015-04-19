public VectorMath sumar(VectorMath vec) throws DistDimException{
		if (dim != vec.dim)
			throw new DistDimException(" Distinta Dimension ");
		 
		VectorMath aux = new VectorMath(dim);
		for (int i=0; i<dim; i++)
			aux.coord[i]=this.coord[i]+vec.coord[i];
		return aux;




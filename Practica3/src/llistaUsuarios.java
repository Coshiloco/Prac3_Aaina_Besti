//Alberto Mas
public class llistaUsuarios {
    
    private Usuario[] usuarios;
    private int nElem;

    public llistaUsuarios (int mida) {
        usuarios =new Usuario[mida];
        nElem=0;
        }
        public String toString () {
            if(nElem==0){return null;}
            String aux = "Llista Usuarios =>";
            for (int i = 0; i<nElem; i++) {
                aux = aux + "\n\t[" + i + "] " + usuarios[i];
            }
            return aux;
        }
     public void afegirU (String alies, String correu, int cpostal) {
            if (nElem < usuarios.length) {
                usuarios[nElem] = new Usuario(alies, correu, cpostal);
                nElem++;
            }
            
            }
            
            
            public Usuario[] getUsuarios() {
                return usuarios;
            }

            public void setUsuarios(Usuario[] usuarios) {
                this.usuarios = usuarios;
            }

            public int getnElem() {
                return nElem;
            }

            public void setnElem(int nElem) {
                this.nElem = nElem;
            }
        
}

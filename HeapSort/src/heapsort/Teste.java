package heapsort;

public class Teste {  
  
    public static void main(String[]args){  
        int [] numeros = new int[]{1, 7, 5, 4, 2, 9, 3, 8, 6, 0};  
          
        // Apresenta valores antes de ordenar  
        System.out.println("antes:");  
        
        for (int i=0;i<numeros.length;i++){
        //for (int n : numeros){  
            System.out.print(" " + numeros[i]);   
        }  
        System.out.println();  
  
        // Ordena os números  
        heapSort(numeros);  
          
        // Apresenta valores depois de ordenar  
        System.out.println("depois:");  
        for (int i=0;i<numeros.length;i++){
             System.out.print(" " + numeros[i]);  
        } 
        
        System.out.println();  
       
    }  
  
    public static void heapSort(int v[]) {  
        //primeiro cria a estrutura heap no vetor  organizando tudo
        buildMaxHeap(v);  
        int n = v.length;  
        // organiza o vetor
        for (int i = v.length - 1; i > 0; i--) { 
            //pega a raiz e coloca na ultima posição do vetor
            swap(v, i, 0);  
            //re-organiza o restante do vetor para coloca o maior numero na raiz
            maxHeapify(v, 0, --n);  
        }  
    }  
   //metodo constroi o heap no vetor
    private static void buildMaxHeap(int v[]) {
         
        //pega o tamanho do vetor e divide por dois menos 1 e vai diminuindo até não ouvber mais posições no vetor
        for (int i = v.length / 2 - 1; i >= 0; i--)  
            maxHeapify(v, i, v.length);  
    }  
   // metodo de organização
    private static void maxHeapify(int v[], int pos, int tamVet) {  
        //filho esquerdo recebe a posição do pai vezes 2 + 1 a psosição da direita é a esquerda mais 1
        int esqrd = 2 * pos + 1, dir = esqrd + 1;  
        //verifica se o filho esquerdo é uma posição valida
        if (esqrd < tamVet) { 
            //se o filho direito é uma posição valida e o valor da esquerda for menor que o filho da direita
            if (dir < tamVet && v[esqrd] < v[dir]) 
                //o valor da esquerda recebe o valor da direita pois a esquerda tem semrpe que ficar com o menor
                 esqrd = dir;  
            //se o valor da esquerda fpor maior que o do pai, existe uma troca entre o valor da raiz(pai) e seu filho da esquerda 
            if (v[esqrd] > v[pos]) {  
                swap(v, esqrd, pos);
                // chama o metodo de organização novamente
                maxHeapify(v, esqrd, tamVet);  
            }  
        }  
    }  
    //metodo que realiza a troca no vetor pelo indice 
    private static void swap(int[] v, int j, int aposJ) {  
        int aux = 0;  
        aux = v[j];  
        v[j] = v[aposJ];  
        v[aposJ] = aux;  
    }  
  
}
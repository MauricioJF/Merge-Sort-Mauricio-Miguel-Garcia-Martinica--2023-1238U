public class App {
    public static void mergeSort(int[] arr, int left, int right ) {
     
        if (left < right) {
             // Encuentra el punto medio del arreglo 
            int mid = (left + right) / 2;
            // Ordena recursivamente la mitad izquierda
             mergeSort(arr, left, mid); 
             // Ordena recursivamente la mitad derecha
              mergeSort(arr, mid + 1, right);
            // Combina las dos mitades ordenadas
             merge(arr, left, mid, right);
        }}  }

        private static void merge(int[] arr, int left, int mid, int right) { 
          
            // Tamaños de los subarreglos a fusionar
           
            int sizeleft = mid - left + 1;
            int sizeRight = right - mid;
            
             // Arreglos temporales para almacenar los subarreglos
             
            int[] tempLeft = new int[sizeleft]; 
            int[] tempRight = new int[sizeRight];
            
             // copia datos a los arreglos temporales 
            
             for (int i = 0; i < sizeleft; i++) { 
                tempLeft[i] = arr[left + i]; 
                
                for (int j = 0; j < sizeRight; j++) { 
                    tempRight[j] = arr[mid + 1 + j]; }
            
             // Fusiona los subarreglos temporales en el arreglo original
             
            int i = 0, j = 0; 
            int k = left;
             
             // Indice inicial para el arreglo fusionado
            while (i < sizeleft && j < sizeRight) { 
                if (tempLeft[i] <= tempRight[j]) {
                     arr[k] = tempLeft[i];
                      i++; } 
                     
                      else { 
                        arr[k] = tempRight[j]; j++; 
                       }
                        k++;
            }
            // Copia elementos restantes de tempLeft[] si los hay 
             while (i < sizeleft) {
                 arr[k] = tempLeft[i]; 
                 i++; 
                 k++; }

            // Copia elementos restantes de tempRight[] si los hay 
             while (j < sizeRight) {
                 arr[k] = tempRight[j]; 
                 j++; 
                 k++;
             }}}    

package app.process;

import util.message.Message;

import java.util.List;

public class ProcessDataImp implements ProcessData {

    @Override
    public void processData(List<String> numberList, Integer numberForProcess) {
        if(numberForProcess > numberList.size()) {
            Message.showMessageDialog("el numero para operar N no puede ser mayor a la cantidad de elementos del arreglo");
        } else {
            Float acumulado = (float) 0;
            System.out.println("tamaño de la lista "+ numberList.size()+ " numero de elemento a tomar "+ numberForProcess);
            for(int i = numberList.size(); i > (numberList.size() - numberForProcess); i-- ) {
                Float value = Float.parseFloat(numberList.get(i -1));
                acumulado += value;
            }
            Message.showMessageDialog("el acumulado fue de "+ acumulado + " y su raiz es: "+ Math.sqrt(acumulado));
        }
    }

}

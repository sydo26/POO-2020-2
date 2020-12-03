import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o combustível atual do avião e a distância que ele percorrerá para iniciarmos a simulação! Formato: {combustivel} {distancia}");
        Aviao obj = new Aviao(input.nextDouble(), input.nextDouble());
    
        Thread.sleep(1000);
        System.out.println("Avião preparando para decolar!");
        Thread.sleep(1000);
        obj.voar();
        System.out.println("Avião decolou!!");
        double distancia = obj.getDistancia();
        for(int i = 0; i < (int) distancia; i++) {
            Thread.sleep(100);
            if(obj.getCombustivel() <= 0) break;
            if(obj.getDistancia() <= 0) break;
            obj.setDistancia((obj.getDistancia() - 10) < 0 ? 0 : obj.getDistancia() - 10);
            obj.setCombustivel(obj.getCombustivel() - 1);
            System.out.println(obj);
        }

        if(obj.getCombustivel() >= 0) obj.pousar();

        if(obj.isVoando()) {
            System.out.println("Avião caiu...!");
        } else {
            System.out.println("Avião chegou ao seu destino, está pousando...");
        }

    }
}
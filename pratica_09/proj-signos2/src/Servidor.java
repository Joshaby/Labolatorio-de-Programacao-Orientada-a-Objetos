import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Servidor implements ObjetosRemotos_IF {
    private Map<String, List<String>> mapaSignos;
    private final Random r = new Random();

    public Servidor() {
        mapaSignos = new HashMap<>();
        mapaSignos.put("Japa", Arrays.asList("gay", "feio", "gay nojento", "ah mizeravi"));
        mapaSignos.put("Tu", Arrays.asList("menimo", "tudo", "tempo", "que coisa glr"));
    }

    @Override
    public String getMensagemSigno(String signo) {
        List<String> AUX = mapaSignos.get(signo);
        int randomPosi = r.nextInt(AUX.size());
        return AUX.get(randomPosi);
    }

    @Override
    public String getSignosDisponiveis() {
        return mapaSignos.keySet().stream().collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        try {
            Servidor sds = new Servidor();
            ObjetosRemotos_IF stub = (ObjetosRemotos_IF) UnicastRemoteObject.exportObject(sds, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Signos", stub);
            System.err.println("Servidor ativado...");
            /*
            while (true) {
                System.err.print("Deseja colocar mais signos? ");
                String oi = in.next();
                if (oi.equalsIgnoreCase("Sim")) {
                    System.err.print("Digite o signo: ");
                    String signo = in.next();
                    if(adicionarMaisSignos(signo, sds, in)) System.err.print("Signo adicionado!");
                    else System.err.print("Signo já!");
                }
            }
            */
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    /*
    public static boolean adicionarMaisSignos(String signo, Servidor sds, Scanner in) {
        if (sds.mapaSignos.containsKey(signo)) {
            return false;
        }
        List<String> siga = new ArrayList<>();
        String sigv = null;
        while (sigv.equalsIgnoreCase("Parar")) {
            sigv = in.next();
            siga.add(sigv);
        }
        sds.mapaSignos.put(signo, siga);
        return true;
    }
    */
}
package upm.modelo.items;

import upm.controlador.MatchService;

public interface MatchVisitor {
    public abstract void pointRest(MatchService matches);
    public abstract void pointService(MatchService matches);
    public abstract void faultService(MatchService matches);

}

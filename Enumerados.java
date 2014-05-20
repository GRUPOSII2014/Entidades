package Entidades;



public class Enumerados {
	public static enum tipoAlerta{AVISO,ALERTA,NOTIFICACION};
	public static enum tipoTrabajador{ADMINISTRATIVO,MEDICO,ENFERMERO,ADMIN};
	public static enum tipoHabitacion{UVI,UCI,QUIROFANO,OBSERVACION,TRATAMIENTOS};
	public static enum tipoDieta{BLANDA,NORMAL,HIPOCALORICA,HIPERCALORICA,VEGETARIANA};
	public static enum tipoHorarios{DIAGNOSTICO,ENFERMERIA};
	public static enum tipoCita{ENFERMERIA,DIAGNOSTICO,CIRUJIA,LISTA_ESPERA};
	public static enum tipoInforme{URGENCIAS,DIAGNOSTICO,ENFERMERIA,QUIROFANO,TRATAMIENTOS,ALERGIAS,INGRESO};
        public static enum tipoUrgencia{CORTE,DISPARO,GOLPE};
        public static enum tipoRecomendacion{AVISO, IMPORTANTE};
        public static enum estadoUrgencia{FINALIZADO,ESPERA,ATENDIDO,ATENDIENDO,TRATAMIENTO,OBSERVACION};
        public static enum tipoTratamiento{QUIMIOTERAPIA, RADIOTERAPIA, OSTEOPATIA, VACUNA, CURA};
        public static enum diaSemana {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO};
        public static enum tipoHorario {MAÑANA, TARDE, NOCHE, URGENCIAS};
        public static enum estadoCama {LIBRE, OCUPADA , LIMPIEZA, REPARACION, ROTA, DESIFECTANDO};
        public static enum tipoFormulario{QUEJAS,CERTIFICADO_MEDICO};
        public static enum listaEspecialidad{OFTALMOLOGIA, GINECOLOGÍA, TRAUMATOLOGÍA, NEUROLOGÍA, UROLOGÍA, PODOLOGÍA};
        
}
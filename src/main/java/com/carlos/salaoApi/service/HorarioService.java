package com.carlos.salaoApi.service;

import com.carlos.salaoApi.model.Horario;
import com.carlos.salaoApi.model.enumm.DiaSemana;
import com.carlos.salaoApi.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    HorarioRepository repository;


    //metodo para gerar horarios automaticos
    public List<Horario> gerarHorariosSemana(Horario horarioBase) {
        List<Horario> horariosGerados = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        for (int i = 0; i < 7; i++) { // Para os próximos 7 dias
            LocalDate data = hoje.plusDays(i);
            DiaSemana diaSemana = converterParaDiaSemana(data.getDayOfWeek()); // Converte o dia

            if (horarioBase.getDiasDaSemana().contains(diaSemana)) { // Comparação correta com o enum
                Horario novoHorario = new Horario();
                novoHorario.setHoraInicial(horarioBase.getHoraInicial());
                novoHorario.setHoraTerminio(horarioBase.getHoraTerminio());
                novoHorario.setData(data);
                novoHorario.setQuantidadeDisponivel(horarioBase.getQuantidadeDisponivel());
                novoHorario.setDisponivel(true);
                novoHorario.setSalao(horarioBase.getSalao());

                horariosGerados.add(novoHorario);
            }
        }

        // Salva os horários no banco
        return repository.saveAll(horariosGerados);
    }

    private DiaSemana converterParaDiaSemana(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> DiaSemana.SEGUNDA;
            case TUESDAY -> DiaSemana.TERÇA;
            case WEDNESDAY -> DiaSemana.QUARTA;
            case THURSDAY -> DiaSemana.QUINTA;
            case FRIDAY -> DiaSemana.SEXTA;
            case SATURDAY -> DiaSemana.SÁBADO;
            case SUNDAY -> DiaSemana.DOMINGO;
        };
    }




    //metodo para apagar os horarios antigos que não esta sendo usados
    @Transactional
    //@Scheduled(cron = "0 0 2 * * ?") // Executa todo dia às 02:00 da manhã

    @Scheduled(cron = "0 5 17 * * ?") // Executa às 16:16 todos os dias
    public void apagarHorariosAntigosSemAgenda() {
        LocalDate hoje = LocalDate.now();
        repository.deleteHorariosAntigosSemAgenda(hoje);
        System.out.println("Horários antigos sem agenda foram apagados automaticamente.");
    }
}

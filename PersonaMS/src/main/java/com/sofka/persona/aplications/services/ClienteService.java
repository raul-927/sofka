package com.sofka.persona.aplications.services;

import com.sofka.persona.domain.ports.in.CreateClienteIn;
import com.sofka.persona.domain.ports.in.DeleteClienteIn;
import com.sofka.persona.domain.ports.in.SelectClienteIn;
import com.sofka.persona.domain.ports.in.UpdateClienteIn;

public interface ClienteService extends CreateClienteIn, UpdateClienteIn,DeleteClienteIn, SelectClienteIn{

}

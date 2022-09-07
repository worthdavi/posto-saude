import { httpClient } from "../http";
import { Usuario } from "../model/usuario";
import { AxiosResponse } from "axios";

const resourceURL: string = "api/usuario"

export const useUsuarioService = () =>{

    const salvar = async (usuario: Usuario) : Promise<Usuario> => {
        const response: AxiosResponse<Usuario> = await httpClient.post<Usuario>(resourceURL, usuario)
        return response.data
    }
    
    const atualizar = async (usuario: Usuario) : Promise<void> => {
        const url: string = `${resourceURL}/${usuario.idUsuario}` 
        await httpClient.put<Usuario>(url, usuario)
    }

    const deletar = async (id: number) : Promise<void> => {
        const url: string = `${resourceURL}/${id}`
        await httpClient.delete(url)
    }

    const listar = async () : Promise<Usuario[]> => {
        const response: AxiosResponse<Usuario[]> = await httpClient.get(resourceURL)
        return response.data
    }

    return {
        salvar,
        atualizar,
        deletar,
        listar
    }

}
import { httpClient } from "../http";
import { UnidadeDeSaude } from "../model/unidade";
import { AxiosResponse } from "axios";

const resourceURL: string = "api/unidade"

export const useUnidadeDeSaudeService = () =>{

    const salvar = async (unidadeDeSaude: UnidadeDeSaude) : Promise<UnidadeDeSaude> => {
        const response: AxiosResponse<UnidadeDeSaude> = await httpClient.post<UnidadeDeSaude>(resourceURL, unidadeDeSaude)
        return response.data
    }
    
    const atualizar = async (unidadeDeSaude: UnidadeDeSaude) : Promise<void> => {
        const url: string = `${resourceURL}/${unidadeDeSaude.idUnidade}` 
        await httpClient.put<UnidadeDeSaude>(url, unidadeDeSaude)
    }

    const deletar = async (id: number) : Promise<void> => {
        const url: string = `${resourceURL}/${id}`
        await httpClient.delete(url)
    }

    const listar = async () : Promise<UnidadeDeSaude[]> => {
        const response: AxiosResponse<UnidadeDeSaude[]> = await httpClient.get(resourceURL)
        return response.data
    }

    const get = async (id: number) : Promise<UnidadeDeSaude> => {
        const url: string = `${resourceURL}/${id}` 
        console.log("eita papai " + url)
        const response: AxiosResponse<UnidadeDeSaude> = await httpClient.get(url)
        console.log("eita papai " + response)
        return response.data
    }

    return {
        get,
        salvar,
        atualizar,
        deletar,
        listar
    }

}
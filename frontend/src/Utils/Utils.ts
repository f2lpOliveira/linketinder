export function mascararNome(nome: string): string {
    const primeiroParte = nome.slice(0, 2);
    const resto = nome.slice(2).replace(/./g, '*');
    return primeiroParte + resto;
}

export function mascararEmail(email: string): string {
    const partes = email.split('@');
    const primeira_parte = partes[0];
    const tamanho = primeira_parte.length;

    const parte_mascarada = primeira_parte.slice(0, 3) + "***" + primeira_parte.slice(tamanho - 2, tamanho);
    return parte_mascarada + '@' + partes[1];
}

export function mascararCPF(cpf: string): string {
    return cpf.replace(/\d/g, '*');
}

export function mascararCNPJ(cnpj: string): string {
    return cnpj.replace(/\d/g, '*');
}
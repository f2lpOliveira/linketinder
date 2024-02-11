const path = require('path');

module.exports = {
    mode: 'production',
    entry: {
        index: ['./src/index.ts'],
        cadastroCandidato: './src/cadastroCandidato.ts',
        cadastroEmpresa: './src/cadastroEmpresa.ts',
        perfilCandidato: './src/perfilCandidato.ts'
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
        ],
    },
    resolve: {
        extensions: ['.tsx', '.ts', '.js'],
    },
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'public', 'dist'),
    },
};
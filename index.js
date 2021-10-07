const report = require('multiple-cucumber-html-reporter');
const fecha = new Date();

report.generate({
    jsonDir: './src/test/assets/report/',
    reportPath: './src/test/assets/report/',
    //Abrir el navegador después de terminar el test
    openReportInBrowser: true,
    //Duración en segundos de la prueba
    displayDuration: true,
    //La fecha de la carpeta test a crear
    displayReportTime: true,
    //Título en el template
    reportName: "<div style='text-align: center; margin-top: 10px;'><figure><a href='https://www.bancodelaustro.com'><img style='width: 300px; height: 35px;' src='https://www.bancodelaustro.com/Portals/0/LogoBancodelAustroNew.png?ver=2021-01-04-090554-537'></a></figure></div><div style='font-size: 28px; color: #73879C; text-overflow: ellipsis;'>Testing Fitbank</div>",
    //Título en el TAB
    pageTitle: "Report Fitbank",
    //Footer
    pageFooter: "<div></div>",
    metadata:{
        browser: {
            name: 'chrome',
            version: '92.0.45'
        },
        device: 'Local test',
        platform: {
            name: 'ubuntu',
            version: '20.04'
        }
    },
    customData: {
        title: 'Run info',
        data: [
            { label: 'Project', value: 'Project Fitbank' },
            { label: 'Release', value: '1.0' },
            { label: 'Execution Start Time', value: fecha.toLocaleString() },
        ]
    }
});
using Microsoft.ML;

namespace Lab534

{
    internal class Program
    {

      

        static void Main(string[] args)
        {
            string _dataPath = Path.Combine(Environment.CurrentDirectory, "Data", "Student.csv");
        /*    string _modelPath = Path.Combine(Environment.CurrentDirectory, "Data", "StudentClusteringModel.zip");
*/
            var mlContext = new MLContext(seed: 0);
            IDataView dataView = mlContext.Data.LoadFromTextFile<StudentData>(_dataPath, hasHeader: false, separatorChar: ',');
            



            string featuresColumnName = "Features";
            var pipeline = mlContext.Transforms
                .Concatenate(featuresColumnName, "StudyTimePerGoalObj", "RepNumberOfUser", "StudyTimePerObj", "ExamPerfPerObj")
                .Append(mlContext.Clustering.Trainers.KMeans(featuresColumnName, numberOfClusters: 4));




            var model = pipeline.Fit(dataView);



/*            using (var fileStream = new FileStream(_modelPath, FileMode.Create, FileAccess.Write, FileShare.Write))
            {
                mlContext.Model.Save(model, dataView.Schema, fileStream);
            }*/



            var predictor = mlContext.Model.CreatePredictionEngine<StudentData, ClusterPrediction>(model);


            var prediction = predictor.Predict(TestStudentData.Setosa);
            Console.WriteLine($"Cluster: {prediction.PredictedClusterId}");
            Console.WriteLine($"Distances: {string.Join(" ", prediction.Distances ?? Array.Empty<float>())}");
        }


    }
}
